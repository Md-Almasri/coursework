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
        town1.values.addValue(new double[] {4.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.values.addValue(new double[] {5.0208, 1.00, 3.531, 1.5, 2.00, 7.00, 4.00, 62.00});
        town1.values.addValue(new double[] {4.5429, 1.00, 2.275, 1.175, 1.00, 6.00, 3.00, 40.00});
        town1.values.addValue(new double[] {4.5573, 1.00, 4.05, 1.232, 1.00, 6.00, 3.00, 54.00});
        town1.values.addValue(new double[] {5.0597, 1.00, 4.455, 1.121, 1.00, 6.00, 3.00, 42.00});
        town1.values.addValue(new double[] {3.891, 1.00, 4.455, 0.988, 1.00, 7.00, 3.00, 56.00});
        town1.values.addValue(new double[] {5.898, 1.00, 5.85, 1.24, 1.00, 7.00, 3.00, 51.00});
        town1.values.addValue(new double[] {6.6969, 1.5, 6.902, 1.488, 1.00, 7.00, 3.00, 22.00});
        town1.values.addValue(new double[] {8.2464, 1.5, 5.15, 1.664, 2.00, 8.00, 4.00, 50.00});
        town1.values.addValue(new double[] {8.7951, 1.5, 9.89, 1.82, 2.00, 8.00, 4.00, 50.00});
        town1.values.addValue(new double[] {9.0384, 1.00, 7.8, 1.5, 2.00, 7.00, 3.00, 23.00});
        double[] price = town1.values.getX("price");
        double[] x = town1.values.getX("x1");
        town1.values.printList();
        System.out.println("Size of list for town 1 :" + town1.values.getListSize());
        for(int i=0; i<price.length;i++) {
            System.out.println("price: " + price[i]);
        }
        town2.values.printList();
        double[] town1SlopeIntercept = new double[2];
        town1SlopeIntercept = town1.linear.getSlopeInterceptValues(price,x);
        System.out.println(town1SlopeIntercept[0] + "  " + town1SlopeIntercept[1] + "  " + town1SlopeIntercept[2]);
        System.out.println(town1.linear.getFormula());
        
        // Test 
        RegressionAnalysisApp test = new RegressionAnalysisApp();
        test.values.addValue(new double[] {-2,1});
        test.values.addValue(new double[] {5,2});
        test.values.addValue(new double[] {9,3});
        double[] testSlopeIntercept = test.linear.getSlopeInterceptValues(test.values.getX("price"), test.values.getX("x1"));
        System.out.println(testSlopeIntercept[0] + "  " + testSlopeIntercept[1] + "  " + testSlopeIntercept[2]);
        System.out.println(test.linear.getFormula());// y = -7+5.5X
         
        // Another test
        RegressionAnalysisApp test1 = new RegressionAnalysisApp();
        test1.values.addValue(new double[] {1,1});
        test1.values.addValue(new double[] {2,2});
        test1.values.addValue(new double[] {1.30,3});
        test1.values.addValue(new double[] {3.75,4});
        test1.values.addValue(new double[] {2.25,5});
        double[] test1SlopeIntercept = test1.linear.getSlopeInterceptValues(test1.values.getX("price"), test1.values.getX("x1"));
        System.out.println(test1SlopeIntercept[0] + "  " + test1SlopeIntercept[1] + "  " + test1SlopeIntercept[2]);
        System.out.println(test1.linear.getFormula());// Y = 0.425X + 0.785
        
        // Another test
        RegressionAnalysisApp test2 = new RegressionAnalysisApp();
        test2.values.addValue(new double[] {51.6,1994});
        test2.values.addValue(new double[] {53.8,1995});
        test2.values.addValue(new double[] {56.5,1996});
        test2.values.addValue(new double[] {61.8,1997});
        test2.values.addValue(new double[] {64.8,1998});
        test2.values.addValue(new double[] {70.2,1999});
        test2.values.addValue(new double[] {79.9,2000});
        test2.values.addValue(new double[] {75.7,2001});
        test2.values.addValue(new double[] {73.2,2002});
        test2.values.addValue(new double[] {76.0,2003});
        test2.values.addValue(new double[] {80.2,2004});
        double[] test2SlopeIntercept = test2.linear.getSlopeInterceptValues(test2.values.getX("price"), test2.values.getX("x1"));
        System.out.println(test2SlopeIntercept[0] + "  " + test2SlopeIntercept[1] + "  " + test2SlopeIntercept[2]);
        System.out.println(test2.linear.getFormula());// Y = 0.425X + 0.785
    }
}
