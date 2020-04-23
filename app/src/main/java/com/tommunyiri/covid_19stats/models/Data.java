package com.tommunyiri.covid_19stats.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("total_cases")
    @Expose
    private String totalCases;
    @SerializedName("recovery_cases")
    @Expose
    private String recoveryCases;
    @SerializedName("death_cases")
    @Expose
    private String deathCases;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("currently_infected")
    @Expose
    private String currentlyInfected;
    @SerializedName("cases_with_outcome")
    @Expose
    private String casesWithOutcome;
    @SerializedName("mild_condition_active_cases")
    @Expose
    private String mildConditionActiveCases;
    @SerializedName("critical_condition_active_cases")
    @Expose
    private String criticalConditionActiveCases;
    @SerializedName("recovered_closed_cases")
    @Expose
    private String recoveredClosedCases;
    @SerializedName("death_closed_cases")
    @Expose
    private String deathClosedCases;
    @SerializedName("closed_cases_recovered_percentage")
    @Expose
    private String closedCasesRecoveredPercentage;
    @SerializedName("closed_cases_death_percentage")
    @Expose
    private String closedCasesDeathPercentage;
    @SerializedName("active_cases_mild_percentage")
    @Expose
    private String activeCasesMildPercentage;
    @SerializedName("active_cases_critical_percentage")
    @Expose
    private String activeCasesCriticalPercentage;
    @SerializedName("general_death_rate")
    @Expose
    private String generalDeathRate;

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getRecoveryCases() {
        return recoveryCases;
    }

    public void setRecoveryCases(String recoveryCases) {
        this.recoveryCases = recoveryCases;
    }

    public String getDeathCases() {
        return deathCases;
    }

    public void setDeathCases(String deathCases) {
        this.deathCases = deathCases;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCurrentlyInfected() {
        return currentlyInfected;
    }

    public void setCurrentlyInfected(String currentlyInfected) {
        this.currentlyInfected = currentlyInfected;
    }

    public String getCasesWithOutcome() {
        return casesWithOutcome;
    }

    public void setCasesWithOutcome(String casesWithOutcome) {
        this.casesWithOutcome = casesWithOutcome;
    }

    public String getMildConditionActiveCases() {
        return mildConditionActiveCases;
    }

    public void setMildConditionActiveCases(String mildConditionActiveCases) {
        this.mildConditionActiveCases = mildConditionActiveCases;
    }

    public String getCriticalConditionActiveCases() {
        return criticalConditionActiveCases;
    }

    public void setCriticalConditionActiveCases(String criticalConditionActiveCases) {
        this.criticalConditionActiveCases = criticalConditionActiveCases;
    }

    public String getRecoveredClosedCases() {
        return recoveredClosedCases;
    }

    public void setRecoveredClosedCases(String recoveredClosedCases) {
        this.recoveredClosedCases = recoveredClosedCases;
    }

    public String getDeathClosedCases() {
        return deathClosedCases;
    }

    public void setDeathClosedCases(String deathClosedCases) {
        this.deathClosedCases = deathClosedCases;
    }

    public String getClosedCasesRecoveredPercentage() {
        return closedCasesRecoveredPercentage;
    }

    public void setClosedCasesRecoveredPercentage(String closedCasesRecoveredPercentage) {
        this.closedCasesRecoveredPercentage = closedCasesRecoveredPercentage;
    }

    public String getClosedCasesDeathPercentage() {
        return closedCasesDeathPercentage;
    }

    public void setClosedCasesDeathPercentage(String closedCasesDeathPercentage) {
        this.closedCasesDeathPercentage = closedCasesDeathPercentage;
    }

    public String getActiveCasesMildPercentage() {
        return activeCasesMildPercentage;
    }

    public void setActiveCasesMildPercentage(String activeCasesMildPercentage) {
        this.activeCasesMildPercentage = activeCasesMildPercentage;
    }

    public String getActiveCasesCriticalPercentage() {
        return activeCasesCriticalPercentage;
    }

    public void setActiveCasesCriticalPercentage(String activeCasesCriticalPercentage) {
        this.activeCasesCriticalPercentage = activeCasesCriticalPercentage;
    }

    public String getGeneralDeathRate() {
        return generalDeathRate;
    }

    public void setGeneralDeathRate(String generalDeathRate) {
        this.generalDeathRate = generalDeathRate;
    }

    @SerializedName("paginationMeta")
    @Expose
    private PaginationMeta paginationMeta;
    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;

    public PaginationMeta getPaginationMeta() {
        return paginationMeta;
    }

    public void setPaginationMeta(PaginationMeta paginationMeta) {
        this.paginationMeta = paginationMeta;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

}
