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
    public  RegressionAnalysisApp() {
        values = new TownValuesListFunctionality();
        linear = new LinearRegressionAnalysis();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        RegressionAnalysisApp town1 = new RegressionAnalysisApp();
        RegressionAnalysisApp town2 = new RegressionAnalysisApp();
        
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
        double[] town1SlopeIntercept = new double[2];
        String yAxis = "price";
        String xAxis = "x";
        for(int i=1; i<8;i++) {
            if(i == 1) {
                town1SlopeIntercept = town1.linear.getSlopeInterceptSquaredrValues(town1.values.getX(yAxis),town1.values.getX(xAxis + i));
            }
            town1SlopeIntercept = town1.linear.getSlopeInterceptSquaredrValues(town1.values.getX(xAxis + i));
            System.out.println(town1SlopeIntercept[0] + "  " + town1SlopeIntercept[1] + "  " + town1SlopeIntercept[2]);
            System.out.println(town1.linear.getFormula());
        }
        
        // Empty list test
        town2.values.printList();
        
        // Test 
        RegressionAnalysisApp town3 = new RegressionAnalysisApp();
        TownValuesListFunctionality town3Values = town3.values;
        LinearRegressionAnalysis town3Linear = town3.linear;
        town3Values.addValue(new double[] {-2,1});
        town3Values.addValue(new double[] {5,2});
        town3Values.addValue(new double[] {9,3});
        double[] testSlopeIntercept = town3Linear.getSlopeInterceptSquaredrValues(town3Values.getX("price"), town3Values.getX("x1"));
        System.out.println(testSlopeIntercept[0] + "  " + testSlopeIntercept[1] + "  " + testSlopeIntercept[2]);
        System.out.println(town3Linear.getFormula());// y = -7+5.5X
         
        // Another test
        RegressionAnalysisApp town4 = new RegressionAnalysisApp();
        town4.values.addValue(new double[] {1,1});
        town4.values.addValue(new double[] {2,2});
        town4.values.addValue(new double[] {1.30,3});
        town4.values.addValue(new double[] {3.75,4});
        town4.values.addValue(new double[] {2.25,5});
        double[] test1SlopeIntercept = town4.linear.getSlopeInterceptSquaredrValues(town4.values.getX("price"), town4.values.getX("x1"));
        System.out.println(test1SlopeIntercept[0] + "  " + test1SlopeIntercept[1] + "  " + test1SlopeIntercept[2]);
        System.out.println(town4.linear.getFormula());// Y = 0.425X + 0.785
        
        // Another test
        RegressionAnalysisApp town5 = new RegressionAnalysisApp();
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
            town5.values.addValue(i);
        }
        double[] test2SlopeIntercept = town5.linear.getSlopeInterceptSquaredrValues(town5.values.getX("price"), town5.values.getX("x1"));
        System.out.println(test2SlopeIntercept[0] + "  " + test2SlopeIntercept[1] + "  " + test2SlopeIntercept[2]);
        System.out.println(town5.linear.getFormula());// Y = 0.425X + 0.785
        
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
        double[] test6SlopeIntercept = town6.linear.getSlopeInterceptSquaredrValues(town6.values.getX("price"), town6.values.getX("x1"));
        System.out.println(test6SlopeIntercept[0] + "  " + test6SlopeIntercept[1] + "  " + test6SlopeIntercept[2]);
        System.out.println(town6.linear.getFormula());// Y = 1X + 0
    }
}
