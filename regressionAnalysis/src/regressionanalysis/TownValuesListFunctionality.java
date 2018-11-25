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
    private int listSize = -1;
    public  TownValuesListFunctionality() {
        head = new TownValuesList();
    }
    // A method that return the length of the list.
    protected int getListSize() {
        return listSize;
    }
    // Add values to the list.
    protected void addValue(double[] values) {
        listSize++;
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
    // A method that clear the list and srt the head to the null.
    protected void clear() {
        head.setValues(null);
        head.setNext(null);
        listSize = -1;
    }
    // A method that check the list whether it is empty or not.
    private boolean isEmpty(TownValuesList head) {
        return  head.getValues() == null && head.getNext() == null;
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
    // A method that return a specific values of the list.
    public double[] getX(String x) {
        TownValuesList tail;
        tail = head;
        double[] xValues = new double[listSize + 1];
        switch (x) {
            case "price":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[0];
                    tail = tail.getNext();
                }
                break;
            }
            case "x1":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[1];
                    tail = tail.getNext();
                }
                break;
            }
            case "x2":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[2];
                    tail = tail.getNext();
                }
                break;
            }
            case "x3":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[3];
                    tail = tail.getNext();
                }
                break;
            }
            case "x4":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[4];
                    tail = tail.getNext();
                }
                break;
            }
            case "x5":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[5];
                    tail = tail.getNext();
                }
                break;
            }
            case "x6":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[6];
                    tail = tail.getNext();
                }
                break;
            }
            case "x7":{
                for(int i=0; i<=listSize; i++) {
                    xValues[i] = tail.getValues()[7];
                    tail = tail.getNext();
                }
                break;
            }
        }
        return xValues;
    }
}
