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
public class TownValuesListFunctionality {
    /**
     * @param args the command line arguments
     */
    private TownValuesList head;
    public  TownValuesListFunctionality() {
        head = new TownValuesList();
    }
    protected void addValue(double[] values) {
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
    private boolean isEmpty(TownValuesList head) {
        return  head == null;
    }
    public void printList() {
        TownValuesList temp;
        if(isEmpty(head))
            System.out.println("List is empty");
        else {
            temp = head;
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
