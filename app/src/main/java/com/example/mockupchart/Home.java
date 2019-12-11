package com.example.mockupchart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Home extends Fragment {
    BarChart barChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        return inflater.inflate(R.layout.activity_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupChart();
    }

    private void setupChart() {
        barChart = (BarChart) getView().findViewById(R.id.chart);

        barChart.setDrawBarShadow(false);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        barChart.setDrawValueAboveBar(false);
        barChart.setTouchEnabled(false);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 5));
        barEntries.add(new BarEntry(2, 10));
        barEntries.add(new BarEntry(3, 15));
        barEntries.add(new BarEntry(4, 25));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Cash In");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        barChart.setData(barData);
    }
}
