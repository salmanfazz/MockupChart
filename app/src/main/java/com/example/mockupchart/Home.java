package com.example.mockupchart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment implements View.OnClickListener {
    BarChart barChart;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> labelNames;
    CardView labaRugi, cashBank;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        return inflater.inflate(R.layout.activity_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        barChart = getView().findViewById(R.id.chart);
        barChart.setOnClickListener(this);
        cashBank = (CardView) getView().findViewById(R.id.cashBank);
        cashBank.setOnClickListener(this);
        labaRugi = (CardView) getView().findViewById(R.id.labaRugi);
        labaRugi.setOnClickListener(this);

        setupChart();
    }

    private void setupChart() {
        barEntries = new ArrayList<>();
        labelNames = new ArrayList<>();

        BarDataSet barDataSet = new BarDataSet(barEntries(), "Cash In");
        BarDataSet barDataSet2 = new BarDataSet(barEntries2(), "Cash Out");

        barDataSet.setColor(Color.RED);
        barDataSet2.setColor(Color.BLUE);

        Description description = new Description();
        description.setText("");

        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet, barDataSet2);
        barChart.setData(barData);

        String[] months = new String[]{"01 Jan", "01 Feb", "01 Mar", "01 Apr"};

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMinimum(3);

        float barSpace = 0.2f;
        float groupSpace = 0.3f;

        barData.setBarWidth(0.15f);
        barChart.getXAxis().setAxisMinimum(0);

        barChart.groupBars(0, groupSpace, barSpace);
        barChart.setTouchEnabled(true);
        barChart.invalidate();
    }

    private List<BarEntry> barEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 2));
        barEntries.add(new BarEntry(2, 4));
        barEntries.add(new BarEntry(3, 6));
        barEntries.add(new BarEntry(4, 8));

        return barEntries;
    }

    private List<BarEntry> barEntries2() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 4));
        barEntries.add(new BarEntry(2, 6));
        barEntries.add(new BarEntry(3, 8));
        barEntries.add(new BarEntry(4, 10));

        return barEntries;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.cashBank:
                DetailCashBank detailCashBank = new DetailCashBank();
                fragmentTransaction.replace(R.id.fragment_container, detailCashBank);
                fragmentTransaction.commit();
                break;

            case R.id.labaRugi:
                DetailLabaRugi detailLabaRugi = new DetailLabaRugi();
                fragmentTransaction.replace(R.id.fragment_container, detailLabaRugi);
                fragmentTransaction.commit();
                break;

            case R.id.chart:
                DetailCashInCashOut detailCashInCashOut = new DetailCashInCashOut();
                fragmentTransaction.replace(R.id.fragment_container, detailCashInCashOut);
                fragmentTransaction.commit();
        }
    }
}
