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
    private TownValuesList head;
    public  RegressionAnalysisApp() {
        head = new TownValuesList();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        RegressionAnalysisApp town1 = new RegressionAnalysisApp();
        RegressionAnalysisApp town2 = new RegressionAnalysisApp();
        town1.addValue(new double[] {4.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.addValue(new double[] {8.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town2.addValue(new double[] {16.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town2.addValue(new double[] {32.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.printList();
        town2.printList();
    }
    //add a new node to the head of the list if it is value equal null 
    //or add more value to the list
    private void addValue(double[] values) {
        head = head.addValue(head, values);
    }
    public void printList() {
        head.printList(head);
    }
}