package com.example.test;

import java.util.ArrayList;

public class country_data_model {

    public String name;
    public String capital;
    public String region;
    public String alpha2Code;
    public String alpha3Code;
    public String[] callingCodes;
    public String population;
    public ArrayList<CurrenciesData> currencies;
    public ArrayList<LanguagesData> languages;
    public String[] flags;
    public String[] latlng;
    public String[] borders;
    public String status;
    public String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getCallingCodes() {
        return callingCodes[0];
    }

    public void setCallingCodes(String[] callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public ArrayList<CurrenciesData> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<CurrenciesData> currencies) {
        this.currencies = currencies;
    }

    public ArrayList<LanguagesData> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<LanguagesData> languages) {
        this.languages = languages;
    }

    public String getFlags() {
        return flags[0];
    }

    public void setFlags(String[] flags) {
        this.flags = flags;
    }

    public String getLatlng() {
        String result = latlng[0] + " , " + latlng[1];
        return result;
    }

    public String getLat(){
        return latlng[0];
    }

    public String getLong(){
        return latlng[1];
    }

    public void setLatlng(String[] latlng) {
        this.latlng = latlng;
    }

    public String[] getBorders() {
        return borders;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class CurrenciesData{

        public String code;
        public String name;
        public String symbol;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public class LanguagesData{

        public String iso639_1;
        public String iso639_2;
        public String name;
        public String nativeName;

        public String getIso639_1() {
            return iso639_1;
        }

        public void setIso639_1(String iso639_1) {
            this.iso639_1 = iso639_1;
        }

        public String getIso639_2() {
            return iso639_2;
        }

        public void setIso639_2(String iso639_2) {
            this.iso639_2 = iso639_2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }

    }

}
