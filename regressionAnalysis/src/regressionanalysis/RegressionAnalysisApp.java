/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regressionanalysis;

/**
 *
 * @author MohiEddin
 */
public class RegressionAnalysisApp {
    /**
     * @param args the command line arguments
     */
    protected TownValuesListFunctionality values;
    protected LinearRegressionAnalysis linear;
    protected DetailedData detailedData;
    public  RegressionAnalysisApp() {
        values = new TownValuesListFunctionality();
        linear = new LinearRegressionAnalysis();
        detailedData = new DetailedData();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        RegressionAnalysisApp town1 = new RegressionAnalysisApp();
        
        // An array that contains town1 data
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
            town1.values.addValue(i);
        }
        
        //
        DetailedData town1SlopeIntercept = new DetailedData();
        String yAxis = "price";
        String xAxis = "x";
        for(int i=1; i<8;i++) {
            town1SlopeIntercept = town1.linear.getLinear(town1.values.getX(yAxis),town1.values.getX(xAxis + i));
            System.out.println(town1SlopeIntercept.intercept + "  " + town1SlopeIntercept.slope + "  " + town1SlopeIntercept.squaredR);
        }
        
        // Another test
        RegressionAnalysisApp town6 = new RegressionAnalysisApp();
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
            town6.values.addValue(i);
        }
        DetailedData test = town6.linear.getLinear(town6.values.getX("price"), town6.values.getX("x1"));
        System.out.println(test.intercept + "  " + test.slope + "  " + test.squaredR);
    }
}
