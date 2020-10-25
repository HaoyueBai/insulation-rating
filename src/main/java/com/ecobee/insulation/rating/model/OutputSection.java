package com.ecobee.insulation.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@NonNull
@AllArgsConstructor
public class OutputSection {

    private String name;
    private String region;
    private int rate;

    public String toString(){
        return "\"" + name  + "\" \"" + region + "\" " + rate;
    }
}
