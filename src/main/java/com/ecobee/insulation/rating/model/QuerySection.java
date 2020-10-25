package com.ecobee.insulation.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
@AllArgsConstructor
public class QuerySection {
    private String name;
    private String region;

}
