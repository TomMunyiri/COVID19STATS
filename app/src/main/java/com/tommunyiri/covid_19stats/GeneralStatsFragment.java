package com.tommunyiri.covid_19stats;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tommunyiri.covid_19stats.models.GeneralStats;
import com.tommunyiri.covid_19stats.rest.NetworkClient;
import com.tommunyiri.covid_19stats.rest.StatsAPIs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralStatsFragment extends Fragment {
    private TextView tvTotalCasesFigure, tvGeneralLastUpdated, tvDeathsFigure, tvRecoveryFigure, tvActiveCasesFigure,
            tvCriticalActiveFigure, tvMildActiveFigure, tvClosedCasesFigure, tvDeathClosedFigure, tvRecoveredClosedFigure;
    private ProgressBar pbWorldStats;
    private RelativeLayout rlWorldStats;
    private SwipeRefreshLayout srWorldStat;

    public GeneralStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_general_stats, container, false);
        tvTotalCasesFigure = v.findViewById(R.id.tvTotalCasesFigure);
        tvGeneralLastUpdated = v.findViewById(R.id.tvGeneralLastUpdated);
        tvDeathsFigure = v.findViewById(R.id.tvDeathsFigure);
        tvRecoveryFigure = v.findViewById(R.id.tvRecoveryFigure);
        tvActiveCasesFigure = v.findViewById(R.id.tvActiveCasesFigure);
        tvCriticalActiveFigure = v.findViewById(R.id.tvCriticalActiveFigure);
        tvMildActiveFigure = v.findViewById(R.id.tvMildActiveFigure);
        tvClosedCasesFigure = v.findViewById(R.id.tvClosedCasesFigure);
        tvDeathClosedFigure = v.findViewById(R.id.tvDeathClosedFigure);
        tvRecoveredClosedFigure = v.findViewById(R.id.tvRecoveredClosedFigure);
        pbWorldStats = v.findViewById(R.id.pbWorldStats);
        rlWorldStats = v.findViewById(R.id.rlWorldStats);
        srWorldStat = v.findViewById(R.id.srWorldStat);
        srWorldStat.setColorSchemeColors(Color.MAGENTA,Color.GREEN,Color.RED);
        fetchWorldStats();
        srWorldStat.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchWorldStats();
            }
        });
        return v;
    }

    private void fetchWorldStats() {
        //Obtain an instance of Retrofit by calling the static method.
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        StatsAPIs statsAPIs = retrofit.create(StatsAPIs.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Call call = statsAPIs.getGeneralStats();
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        pbWorldStats.setVisibility(View.VISIBLE);
        rlWorldStats.setVisibility(View.INVISIBLE);
        call.enqueue(new Callback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    pbWorldStats.setVisibility(View.INVISIBLE);
                    rlWorldStats.setVisibility(View.VISIBLE);
                    srWorldStat.setRefreshing(false);
                    GeneralStats gResponse = (GeneralStats) response.body();
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
                    tvGeneralLastUpdated.setText(getString(R.string.last_updated_text) +formattedDate);
                    tvTotalCasesFigure.setText(gResponse.getData().getTotalCases());
                    tvDeathsFigure.setText(gResponse.getData().getDeathCases());
                    tvRecoveryFigure.setText(gResponse.getData().getRecoveryCases());
                    tvActiveCasesFigure.setText(gResponse.getData().getCurrentlyInfected());
                    tvCriticalActiveFigure.setText(gResponse.getData().getCriticalConditionActiveCases());
                    tvMildActiveFigure.setText(gResponse.getData().getMildConditionActiveCases());
                    tvClosedCasesFigure.setText(gResponse.getData().getCasesWithOutcome());
                    tvDeathClosedFigure.setText(gResponse.getData().getDeathClosedCases());
                    tvRecoveredClosedFigure.setText(gResponse.getData().getRecoveredClosedCases());
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
