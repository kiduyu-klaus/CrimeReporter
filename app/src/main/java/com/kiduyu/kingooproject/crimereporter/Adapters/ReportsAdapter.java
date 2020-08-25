package com.kiduyu.kingooproject.crimereporter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kiduyu.kingooproject.crimereporter.Models.Reports;
import com.kiduyu.kingooproject.crimereporter.R;

import java.util.List;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.MyViewHolder>  {
    Context mcontext;
    private List<Reports> reportsList;

    public ReportsAdapter(Context context, List<Reports> HomeList) {
        this.reportsList = HomeList;
        this.mcontext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.report_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Reports reports = reportsList.get(position);

        holder.name.setText(reports.getName());

    }

    @Override
    public int getItemCount() {
        return reportsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,format,size;
        Button open;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.report_name);
            open=itemView.findViewById(R.id.repor_open);
        }
    }
}
