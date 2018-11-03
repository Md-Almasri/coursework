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
    public  RegressionAnalysisApp() {
        values = new TownValuesListFunctionality();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        RegressionAnalysisApp town1 = new RegressionAnalysisApp();
        RegressionAnalysisApp town2 = new RegressionAnalysisApp();
        town1.values.addValue(new double[] {4.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.values.addValue(new double[] {8.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town2.values.addValue(new double[] {16.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town2.values.addValue(new double[] {32.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.values.printList();
        town2.values.printList();
    }
}