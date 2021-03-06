package com.muxistudio.oneday.ui.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.muxistudio.oneday.R;
import com.muxistudio.oneday.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengminchao on 17/11/18
 */

public class StatisticFragment extends BaseFragment{

    private LineChart mLineChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic,container,false);
        mLineChart = view.findViewById(R.id.line_chart);
        initView();
        return view;
    }

    private void initView() {

        LineChartManager lineChartManager1 = new LineChartManager(mLineChart);

        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }

        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.RED);
        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        //创建多条折线的图表
        lineChartManager1.showLineChart(xValues, yValues.get(0), names.get(1), colours.get(3));
        lineChartManager1.setYAxis(100, 0, 11);
//        lineChartManager1.setHightLimitLine(70,"高温报警",Color.RED);

    }
}
