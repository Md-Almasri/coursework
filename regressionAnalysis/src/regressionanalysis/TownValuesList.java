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
    declare variables which are:
    Price: selling price (£100000's)
    x1: no of bathrooms
    x2: area of the site (1000's square feet)
    x3: size of living space (1000's square feet)
    x4: no of garages
    x5: no of rooms
    x6: no of bedrooms
    x7: age of property (years)
    */
//    private double price, x1, x2, x3, x4, x5, x6, x7;
//    private TownList next;
//    public TownList() {
//        /** Creates a node with null references to its element and next node. */
//        this(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, null);
//    }
//    /** Creates a node with the given element and next node. */
//    public TownList(double price, double x1, double x2, double x3, double x4, double x5, double x6, double x7, TownList next) {
//        this.price = price;
//        this.x1 = x1;
//        this.x2 = x2;
//        this.x3 = x3;
//        this.x4 = x4;
//        this.x5 = x5;
//        this.x6 = x6;
//        this.x7 = x7;
//        this.next = next;
//    }
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
    public TownValuesList() {
        /** Creates a node with null references to its element and next node. */
        this(null, null);
    }
    /** Creates a node with the given element and next node. */
    public TownValuesList(double[] values, TownValuesList next) {
        this.values = values;
        this.next = next;
    }
    // Accessor methods:
    public double[] getValues() {
        return values;
    }
    public TownValuesList getNext() {
        return next;
    }
    // Modifier methods:
    public void setValues(double[] newElem) { 
        values = newElem;
  }
    public void setNext(TownValuesList newNext) {
        next = newNext; 
  }
}
