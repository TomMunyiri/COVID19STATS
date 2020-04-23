package com.tommunyiri.covid_19stats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tommunyiri.covid_19stats.R;
import com.tommunyiri.covid_19stats.models.Row;

import java.util.List;

public class CountryStatAdapter extends RecyclerView.Adapter<CountryStatAdapter.CountryStatViewHolder> {

    private List<Row> countrystats;
    private int rowLayout;
    private Context context;


    public static class CountryStatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llCountry;
        TextView tvTotalCasesFigure, tvDeathsFigure, tvRecoveryFigure, tvActiveCasesFigure, tvNewDeathsFigure, tvNewCasesFigure, tvCriticalCasesFigure;


        public CountryStatViewHolder(View v) {
            super(v);
            llCountry = v.findViewById(R.id.llCountry);
            tvTotalCasesFigure = v.findViewById(R.id.tvTotalCasesFigure);
            tvDeathsFigure = v.findViewById(R.id.tvDeathsFigure);
            tvRecoveryFigure = v.findViewById(R.id.tvRecoveryFigure);
            tvActiveCasesFigure = v.findViewById(R.id.tvActiveCasesFigure);
            tvNewDeathsFigure = v.findViewById(R.id.tvNewDeathsFigure);
            tvNewCasesFigure = v.findViewById(R.id.tvNewCasesFigure);
            tvCriticalCasesFigure = v.findViewById(R.id.tvCriticalCasesFigure);
        }
    }

    public CountryStatAdapter(List<Row> countrystats, int rowLayout, Context context) {
        this.countrystats = countrystats;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CountryStatAdapter.CountryStatViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CountryStatViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CountryStatViewHolder holder, final int position) {
        holder.tvTotalCasesFigure.setText(countrystats.get(position).getTotalCases());
        holder.tvDeathsFigure.setText(countrystats.get(position).getTotalDeaths());
        holder.tvRecoveryFigure.setText(countrystats.get(position).getTotalRecovered());
        holder.tvActiveCasesFigure.setText(countrystats.get(position).getActiveCases());
        holder.tvNewDeathsFigure.setText(countrystats.get(position).getNewDeaths());
        holder.tvNewCasesFigure.setText(countrystats.get(position).getNewCases());
        holder.tvCriticalCasesFigure.setText(countrystats.get(position).getSeriousCritical());
    }

    @Override
    public int getItemCount() {
        return countrystats.size();
    }
}
