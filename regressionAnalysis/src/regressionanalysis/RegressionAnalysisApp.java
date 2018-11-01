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
    protected TownValuesList head;
    public  RegressionAnalysisApp() {
        head = new TownValuesList();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the course work");
        RegressionAnalysisApp town1 = new RegressionAnalysisApp();
        town1.addValue(new double[] {4.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.addValue(new double[] {8.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        town1.addValue(new double[] {16.9176, 1.00, 3.472, 0.998, 1.00, 7.00, 4.00, 42.00});
        printList(town1);
    }
    private boolean isEmpty() {
        return  head == null;
    }
    //add a new node to the head of the list if it is value equal null 
    //or add more value to the list
    private void addValue(double[] values) {
        if(head.getValues() == null) {
            // make variable head point to new node
            head = new TownValuesList(values, null);
        }
        else 
        {
            TownValuesList tail;
            tail = head;
            while(tail.getNext() != null){
                tail = tail.getNext();
            }
            //insert new node at end of list
            tail.setNext( new TownValuesList(values, null));
        }
    }
    public static void printList(RegressionAnalysisApp town1) {
        TownValuesList temp;
        if(town1.isEmpty())
            System.out.println("List is empty");
        else {
            temp = town1.head;
            double[] v = new double[8];
            while (temp != null) {
                v = temp.getValues();
                for(int i=0; i<v.length; i++) {
                    System.out.println(v[i]);
                }
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
