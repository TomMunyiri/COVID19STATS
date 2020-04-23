package com.tommunyiri.covid_19stats.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_abbreviation")
    @Expose
    private String countryAbbreviation;
    @SerializedName("total_cases")
    @Expose
    private String totalCases;
    @SerializedName("new_cases")
    @Expose
    private String newCases;
    @SerializedName("total_deaths")
    @Expose
    private String totalDeaths;
    @SerializedName("new_deaths")
    @Expose
    private String newDeaths;
    @SerializedName("total_recovered")
    @Expose
    private String totalRecovered;
    @SerializedName("active_cases")
    @Expose
    private String activeCases;
    @SerializedName("serious_critical")
    @Expose
    private String seriousCritical;
    @SerializedName("cases_per_mill_pop")
    @Expose
    private String casesPerMillPop;
    @SerializedName("flag")
    @Expose
    private String flag;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getSeriousCritical() {
        return seriousCritical;
    }

    public void setSeriousCritical(String seriousCritical) {
        this.seriousCritical = seriousCritical;
    }

    public String getCasesPerMillPop() {
        return casesPerMillPop;
    }

    public void setCasesPerMillPop(String casesPerMillPop) {
        this.casesPerMillPop = casesPerMillPop;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
