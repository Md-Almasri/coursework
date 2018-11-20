/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regressionanalysis;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author MohiEddin
 */
public class RegressionAnalysisApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        
        // Example 1. start
        // Create town 1 instance.
        TownValuesListFunctionality town1 = new TownValuesListFunctionality();
        // A sample of data which is an array that contains town1 data
        double[][] town1Data = new double[][]{
                        {4.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00},
                        {5.0208, 1.00, 3.531, 1.5, 2.00, 7.00, 4.00, 62.00},
                        {4.5429, 1.00, 2.275, 1.175, 1.00, 6.00, 3.00, 40.00},
                        {4.5573, 1.00, 4.05, 1.232, 1.00, 6.00, 3.00, 54.00},
                        {5.0597, 1.00, 4.455, 1.121, 1.00, 6.00, 3.00, 42.00},
                        {3.891, 1.00, 4.455, 0.988, 1.00, 7.00, 3.00, 56.00},
                        {5.898, 1.00, 5.85, 1.24, 1.00, 7.00, 3.00, 51.00},
                        {6.6969, 1.5, 6.902, 1.488, 1.00, 7.00, 3.00, 22.00},
                        {8.2464, 1.5, 5.15, 1.664, 2.00, 8.00, 4.00, 50.00},
                        {8.7951, 1.5, 9.89, 1.82, 2.00, 8.00, 4.00, 50.00},
                        {9.0384, 1.00, 7.8, 1.5, 2.00, 7.00, 3.00, 23.00}
                    };
        // Add values to the town1 list
        for(double[] i:town1Data){
            town1.addValue(i);
        }
        // Create an instance of DetailedData class that will contain all required values.
        DetailedData town1DetailedData;
        String yAxis = "price";
        String xAxis = "x";
        for(int i=1; i<8;i++) {
            town1DetailedData = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + i));
            System.out.println(town1DetailedData.intercept + "  " + town1DetailedData.slope + "  " + town1DetailedData.squaredR);
        }
        // Example 1. finish
        
        // Example 2. start
        // Empty list test
        TownValuesListFunctionality town2 = new TownValuesListFunctionality();
        town2.printList();
        // Example 2. finish
        
        // Example 3. start
        TownValuesListFunctionality town3 = new TownValuesListFunctionality();
        town3.addValue(new double[] {-2,1});
        town3.addValue(new double[] {5,2});
        town3.addValue(new double[] {9,3});
        DetailedData town3DetailedData = LinearRegressionAnalysis.getLinear(town3.getX("price"), town3.getX("x1"));
        System.out.println(town3DetailedData.intercept + "  " + town3DetailedData.slope + "  " + town3DetailedData.squaredR);// y = -7+5.5X
        // Example 3. finish
        
        // Example 4. start.
        // Another test
        TownValuesListFunctionality town4 = new TownValuesListFunctionality();
        town4.addValue(new double[] {1,1});
        town4.addValue(new double[] {2,2});
        town4.addValue(new double[] {1.30,3});
        town4.addValue(new double[] {3.75,4});
        town4.addValue(new double[] {2.25,5});
        DetailedData town4DetailedData = LinearRegressionAnalysis.getLinear(town4.getX("price"), town4.getX("x1"));
        System.out.println(town4DetailedData.intercept + "  " + town4DetailedData.slope + "  " + town4DetailedData.squaredR);// Y = 0.425X + 0.785
        // Example 4. finish.
        
        // Example 5. start.
        TownValuesListFunctionality town5 = new TownValuesListFunctionality();
        double[][] town5Data = new double[][]{
                        {51.6,1994},
                        {53.8,1995},
                        {56.5,1996},
                        {61.8,1997},
                        {64.8,1998},
                        {70.2,1999},
                        {79.9,2000},
                        {75.7,2001},
                        {73.2,2002},
                        {76.0,2003},
                        {80.2,2004}
                    };
        for(double[] i:town5Data){
            town5.addValue(i);
        }
        DetailedData town5DetailedData = LinearRegressionAnalysis.getLinear(town5.getX("price"), town5.getX("x1"));
        System.out.println(town5DetailedData.intercept + "  " + town5DetailedData.slope + "  " + town5DetailedData.squaredR);// Y = 0.425X + 0.785
        // Example 5. finish.
        
        // Example 6. start
        TownValuesListFunctionality town6 = new TownValuesListFunctionality();
        double[][] town6Data = new double[][]{
                        {1,1},
                        {2,2},
                        {3,3},
                        {4,4},
                        {5,5},
                        {6,6},
                        {7,7},
                        {8,8}
                    };
        for(double[] i:town6Data){
            town6.addValue(i);
        }
        DetailedData town6DetailedData = LinearRegressionAnalysis.getLinear(town6.getX("price"), town6.getX("x1"));
        System.out.println(town6DetailedData.intercept + "  " + town6DetailedData.slope + "  " + town6DetailedData.squaredR);
        // Example 6. finish.
        // examples how to get any detailed data for each town.
        System.out.println(town6DetailedData.intercept);
        System.out.println(town6DetailedData.meanOfX);
        System.out.println(town6DetailedData.meanOfY);
        
        double[] x = town4.getX("x1");
        double[] y = town4.getX("price");
        double[] s = {
            town4DetailedData.slope,
            town4DetailedData.intercept,
            town4DetailedData.squaredR
        };
        Graph graph = new Graph();
        JPanel dDPnl = new JPanel();
        JPanel panel2 = new JPanel();
        String[] choices = {
            "No. of Bathrooms",
            "Area of the Site",
            "Size of Living Space",
            "No. of Garages",
            "No. of Rooms",
            "No. of Bedrooms",
            "Age of property"
        };
        JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        dDPnl.add(cb);
        JButton btn = new JButton("Change");
        dDPnl.add(btn);
        JFrame f =  new JFrame();
        f.setSize(800, 800);
        f.setTitle("House Price Estimator");
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(Graph.graphPanel, BorderLayout.CENTER);
        f.add(dDPnl, BorderLayout.EAST);
        f.add(Graph.graphPanel, BorderLayout.CENTER);
        f.pack();
        cb.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xChosen = cb.getSelectedItem().toString();
                DetailedData SlopeIntercept;
                if (xChosen == "No. of Bathrooms") {
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 1));
//                    graph.update(SlopeIntercept.xAxisValues, SlopeIntercept.yAxisValues, new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                    // or
                    graph.update(town1.getX(xAxis + 1), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "Area of the Site"){
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 2));
                    graph.update(town1.getX(xAxis + 2), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "Size of Living Space"){
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 3));
                    graph.update(town1.getX(xAxis + 3), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "No. of Garages"){
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 4));
                    graph.update(town1.getX(xAxis + 4), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "No. of Rooms"){
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 5));
                    graph.update(town1.getX(xAxis + 5), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "No. of Bedrooms") {
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 6));
                    graph.update(town1.getX(xAxis + 6), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                } else if (xChosen == "Age of property") {
                    SlopeIntercept = LinearRegressionAnalysis.getLinear(town1.getX(yAxis),town1.getX(xAxis + 7));
                    graph.update(town1.getX(xAxis + 7), town1.getX(yAxis), new double[] {SlopeIntercept.slope, SlopeIntercept.intercept});
                }
            }
        });
    }
}
