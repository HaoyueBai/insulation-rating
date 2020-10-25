package com.ecobee.insulation.rating.service;

import com.ecobee.insulation.rating.model.DataSection;
import com.ecobee.insulation.rating.model.OutputSection;
import com.ecobee.insulation.rating.model.QuerySection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateCalculationService {

    @Autowired
    private InputService inputService;

    private HashMap<String,Double> nameToRvalue;
    private HashMap<String, ArrayList<DataSection>> processedData;
    private ArrayList<QuerySection> queries;

    public void reportRate(){

        nameToRvalue = inputService.getNameToRvalue();
        processedData = inputService.getProcessedData();
        queries = inputService.getQueries();

        queries.stream()
                .map(q -> calculateRate(q))
                .forEach(System.out::println);
    }

    private OutputSection calculateRate(QuerySection q) {
        Double targetRvalue;
        if(nameToRvalue.containsKey(q.getName())) {
            targetRvalue = nameToRvalue.get(q.getName());
        }else {
            return new OutputSection(q.getName(),q.getRegion(),-1);
        }

        String country = q.getRegion().contains("/") ? q.getRegion().substring(0, q.getRegion().indexOf("/")) : q.getRegion();
        List<DataSection> sameCountry = processedData.get(country);
        if (sameCountry == null || sameCountry.isEmpty()){
            return  new OutputSection(q.getName(),q.getRegion(),-1);
        }
        final List<DataSection> sameRegion = sameCountry.stream()
                .filter(d -> d.getLocation().contains(q.getRegion()))
                .collect(Collectors.toList());
        if (sameRegion == null || sameRegion.isEmpty()){
            return  new OutputSection(q.getName(),q.getRegion(),-1);
        }
        final long betterCount = sameRegion.stream()
                .filter(d -> d.getRValure() > targetRvalue)
                .count();
        Double percentage = Double.valueOf(betterCount)/Double.valueOf(sameRegion.size());

        return new OutputSection(q.getName(),q.getRegion(), (int) ((1-percentage)*10));
    }
    }


