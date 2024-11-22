package com.textprocessingtool.models;


import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCollection {
    

    private int id;
    private String name;
    private ArrayList<String> features;

    // use generics here
    private HashMap<String,String> entries;

    public DataCollection(String name) {
        this.name = name;
    }

    public DataCollection(String name, ArrayList<String> features) {
        this.name = name;
        this.features = features;
    }
}
