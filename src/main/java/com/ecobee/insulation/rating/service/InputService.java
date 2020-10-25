package com.ecobee.insulation.rating.service;

import com.ecobee.insulation.rating.model.DataSection;
import com.ecobee.insulation.rating.model.QuerySection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InputService {

    private  ArrayList<DataSection> datas;
    private  ArrayList<QuerySection> queries;
    private HashMap<String,Double> nameToRvalue;
    private  HashMap<String, ArrayList<DataSection>> processedData;


    private void getInput(){
        datas = new ArrayList<>();
        queries = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isData = true;
        int countEmpty = 0;
        List<String> lineList = new ArrayList<>();
        while (scanner.hasNextLine() == true) {
            lineList.clear();
            String line = scanner.nextLine();
            if (line.isEmpty() && 0 == countEmpty ) {
                isData = false;
                countEmpty++;
            }else if(line.isEmpty()){
                break;
            }
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(line);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    lineList.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    lineList.add(regexMatcher.group(2));
                } else {
                    lineList.add(regexMatcher.group());
                }
            }
            if(isData) {
                datas.add(new DataSection(lineList.get(0), lineList.get(1), Double.parseDouble(lineList.get(2))));
            }else if(!lineList.isEmpty()) {
                queries.add(new QuerySection(lineList.get(0),lineList.get(1)));
            }
        }

    }

    public HashMap<String, ArrayList<DataSection>> getProcessedData() {
        if(datas==null || datas.isEmpty()){
            getInput();
        }
        processedData = new HashMap<>();
        for (DataSection d:datas) {
            String country = d.getLocation().contains("/") ? d.getLocation().substring(0, d.getLocation().indexOf("/")) : d.getLocation();
            ArrayList<DataSection> tmp = processedData.containsKey(country) ? (ArrayList<DataSection>) processedData.get(country) : new ArrayList<>();
            tmp.add(d);
            processedData.put(country,tmp);
        }
        return processedData;
    }

    public HashMap<String,Double> getNameToRvalue(){
        if(datas==null || datas.isEmpty()){
            getInput();
        }
        nameToRvalue = new HashMap<>();
        for (DataSection d:datas) {
            nameToRvalue.put(d.getName(),d.getRValure());
        }
        return nameToRvalue;
    }


    public ArrayList<QuerySection> getQueries(){
        if(queries==null || queries.isEmpty()){
            getInput();
        }
        return queries;
    }



}
