package com.example.module10_firebase;

import java.util.List;

public class City {


    private String name;
    private String state;
    private String country;
    private boolean capital;
    private long population;
    private List<String> regions;

    public City() {}

    public City(String name, String state, String country, boolean capital, long population, List<String> regions) {
        // ...
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public boolean isCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public List<String> getRegions() {
        return regions;
    }

}
