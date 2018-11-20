package regressionanalysis;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph {
    
    static ChartPanel graphPanel;
    static String YAxis = "Prices";
    static String XAxis;
    static String Title = "House Price Estimator";
    static JFreeChart chart;
    static XYSeriesCollection dataset = new XYSeriesCollection();
    static XYSeries lineData = new XYSeries("Line Plot");
    static XYSeries series1 = new XYSeries("Data 1");
    static XYSeries series2 = new XYSeries("Data 2");
    
    public Graph() {
        dataset.removeAllSeries();
        lineData.clear();
        series1.clear();
        series2.clear();
        
        // Create chart
        chart = ChartFactory.createXYLineChart(
            Title,
            XAxis,
            YAxis,
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);
    
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(134, 134, 121, 70));
        chart.getTitle().setPaint(new Color(61, 153, 245));
    
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // "0" is the line plot
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);

        // "1" is the scatter plot
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);
        
        // "1" is the scatter plot
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, true);

        plot.setRenderer(renderer);
         
        // Create Panel
        graphPanel = new ChartPanel(chart);
    }
    public static void update(double[] x1,double[] y, double[] slopeInterceptValues) {
        dataset.removeAllSeries();
        lineData.clear();
        series1.clear();
        series2.clear();
        
        ArrayList<Double> yValues = new ArrayList<Double>();
        
        //Line Data
        for (double i : x1) {
            double number2 = (slopeInterceptValues[0] * i) + slopeInterceptValues[1];
            yValues.add(number2);
        }
        
        for (int i = 0; i < y.length; i++) {
            lineData.add(x1[i], yValues.get(i));
        }
        
        //Chart Data
        for (int i = 0; i < x1.length; i++){
            //series1.add(x1[i], y[i]);
            series1.addOrUpdate(x1[i], y[i]);
        }
    
                
        //Add series to dataset
        dataset.addSeries(lineData);
        dataset.addSeries(series1);
    }
    public static void update(double[] x1, double[] x2, double[] y, double[] slopeInterceptValues) {
        dataset.removeAllSeries();
        lineData.clear();
        series1.clear();
        series2.clear();
        
        ArrayList<Double> yValues = new ArrayList<Double>();
        
        //Line Data
        for (double i : x1) {
            double number2 = (slopeInterceptValues[0] * i) + slopeInterceptValues[1];
            yValues.add(number2);
        }
        
        for (int i = 0; i < y.length; i++) {
            lineData.add(x1[i], yValues.get(i));
        }
        
        //Chart Data
        for (int i = 0; i < x1.length; i++){
            //series1.add(x1[i], y[i]);
            series1.addOrUpdate(x1[i], y[i]);
        }
    
        //Chart Data
        for (int i = 0; i < x2.length; i++){
            series2.add(x2[i], y[i]);
        }
        
        //Add series to dataset
        dataset.addSeries(lineData);
        dataset.addSeries(series1);
        dataset.addSeries(series2);
    }
}
