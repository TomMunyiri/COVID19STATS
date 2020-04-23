package com.tommunyiri.covid_19stats;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tommunyiri.covid_19stats.adapters.CountryStatAdapter;
import com.tommunyiri.covid_19stats.models.CountryStats;
import com.tommunyiri.covid_19stats.models.GeneralStats;
import com.tommunyiri.covid_19stats.models.Row;
import com.tommunyiri.covid_19stats.rest.NetworkClient;
import com.tommunyiri.covid_19stats.rest.StatsAPIs;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryStatsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String[] countries;
    SearchableSpinner spCountry;
    private SwipeRefreshLayout srCountryStat;
    private TextView tvCountryLastUpdated, tvNoData;
    private ProgressBar pbCountryStats;
    private RecyclerView rvCountryStats;

    public CountryStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_country_stats, container, false);
        spCountry = v.findViewById(R.id.spCountry);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.Countries, android.R.layout.simple_spinner_item);
        // Specify layout to be used when list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setTitle(getString(R.string.spinner_title));
        // Applying the adapter to our spinner
        spCountry.setAdapter(adapter);
        spCountry.setOnItemSelectedListener(this);
        countries = getContext().getResources().getStringArray(R.array.Countries);
        tvCountryLastUpdated = v.findViewById(R.id.tvCountryLastUpdated);
        tvNoData = v.findViewById(R.id.tvNoData);
        pbCountryStats = v.findViewById(R.id.pbCountryStats);
        rvCountryStats = v.findViewById(R.id.rvCountryStats);
        rvCountryStats.setLayoutManager(new LinearLayoutManager(getContext()));
        srCountryStat = v.findViewById(R.id.srCountryStat);
        spCountry.setPositiveButton("CANCEL");
        srCountryStat.setColorSchemeColors(Color.MAGENTA,Color.GREEN,Color.RED);
        srCountryStat.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String country = spCountry.getSelectedItem().toString();
                fetchCountryStats(country);
            }
        });
        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String country = spCountry.getSelectedItem().toString();
        fetchCountryStats(country);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void fetchCountryStats(String country){
        //Obtain an instance of Retrofit by calling the static method.
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        StatsAPIs statsAPIs = retrofit.create(StatsAPIs.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Call call = statsAPIs.getCountryStats(country);
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        pbCountryStats.setVisibility(View.VISIBLE);
        rvCountryStats.setVisibility(View.INVISIBLE);
        tvNoData.setVisibility(View.INVISIBLE);
        call.enqueue(new Callback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    pbCountryStats.setVisibility(View.INVISIBLE);
                    CountryStats gResponse = (CountryStats) response.body();
                    List<Row>countrystats = gResponse.getData().getRows();
                    String dateStr = gResponse.getData().getLastUpdate();
                    SimpleDateFormat df = new SimpleDateFormat("MMM, dd yyyy, HH:mm", Locale.ENGLISH);
                    df.setTimeZone(TimeZone.getTimeZone("UTC"));
                    Date date = null;
                    try {
                        date = df.parse(dateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    df.setTimeZone(TimeZone.getDefault());
                    String formattedDate = df.format(date);
                    tvCountryLastUpdated.setText(getString(R.string.last_updated_text) + formattedDate);
                    if(countrystats.size()>0){
                        tvNoData.setVisibility(View.INVISIBLE);
                        rvCountryStats.setVisibility(View.VISIBLE);
                        rvCountryStats.setAdapter(new CountryStatAdapter(countrystats,R.layout.country_stat_list_item,getContext()));
                        srCountryStat.setRefreshing(false);
                    }else if(countrystats.size()==0){
                        tvNoData.setVisibility(View.VISIBLE);
                        rvCountryStats.setVisibility(View.INVISIBLE);
                        srCountryStat.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                /*
                Error callback
                */
            }
        });
    }
}
