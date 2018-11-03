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
public class TownValuesList {
    // Instance variables:
    /**
    declare variables which are in an array:
    Price: selling price (£100000's)
    x1: no of bathrooms
    x2: area of the site (1000's square feet)
    x3: size of living space (1000's square feet)
    x4: no of garages
    x5: no of rooms
    x6: no of bedrooms
    x7: age of property (years)
    example of values: [price, x1, x2, x3, x4, x5, x6, x7]
    */
    private double[] values;
    private TownValuesList next;
    protected TownValuesList() {
        /** Creates a node with null references to its element and next node. */
        this(null, null);
    }
    /** Creates a node with the given element and next node. */
    protected TownValuesList(double[] values, TownValuesList next) {
        this.values = values;
        this.next = next;
    }
    // Accessor methods:
    protected double[] getValues() {
        return values;
    }
    protected TownValuesList getNext() {
        return next;
    }
    // Modifier methods:
    protected void setValues(double[] newElem) { 
        values = newElem;
  }
    protected void setNext(TownValuesList newNext) {
        next = newNext; 
  }
    protected TownValuesList addValue(TownValuesList head, double[] values) {
        if(head.getValues() == null) {
            // make variable head point to new node
            return new TownValuesList(values, null);
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
            return head;
        }
    }
    private boolean isEmpty(TownValuesList head) {
        return  head == null;
    }
    public void printList(TownValuesList head) {
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
