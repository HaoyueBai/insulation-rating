package com.ecobee.insulation.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
@AllArgsConstructor
public class DataSection {
    private String name;
    private String location;
    private double rValure;
}