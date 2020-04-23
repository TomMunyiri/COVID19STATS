package com.tommunyiri.covid_19stats.rest;

import com.tommunyiri.covid_19stats.models.CountryStats;
import com.tommunyiri.covid_19stats.models.GeneralStats;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatsAPIs {
    /*
    Get request to fetch city weather.Takes in two parameter-city name and API key.
    */
    @GET("cases/general-stats")
    Call<GeneralStats> getGeneralStats();

    @GET("cases/countries-search")
    Call<CountryStats> getCountryStats(@Query("search") String country);
}
