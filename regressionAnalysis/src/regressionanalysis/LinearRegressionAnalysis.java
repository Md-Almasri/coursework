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
public class LinearRegressionAnalysis {
    // Instances variables:
//    private double xSum, ySum, xMean, yMean, xVariance, yVariance, stdDev, b1, b0;
    public void getFormula(double[] yArr, double[] xArr) {
        double sXX, sXY, b1, b0;
        display(xArr);
        display(yArr);
        double[] xVarianceValue = varianceValue(xArr);
        double[] yVarianceValue = varianceValue(yArr);
        double[] xyVarianceValue = new double[xVarianceValue.length];
        display(xVarianceValue);
        sXX = sumValue(squaredVarianceValue(xVarianceValue));
        for(int i=0; i<xyVarianceValue.length; i++) {
            xyVarianceValue[i] = (xVarianceValue[i])*(yVarianceValue[i]);
        }
        sXY = sumValue(xyVarianceValue);
        b1 = sXY/sXX;
        b0 = meanValue(yArr) - (b1* meanValue(xArr));
        System.out.println("y="+b0+"+"+b1+"x");
    }
    // A method that accept an array as an argument and return the sum of values in that array.
    public double sumValue(double[] arr) {
        double sum = 0;
        for(double i:arr){
            sum += i;
        }
        return sum;
    }
    // A method that return the mean of an array values.
    public double meanValue(double[] arr) {
        return sumValue(arr)/arr.length;
    }
    // A method that return an array which contains the variance of an array value.
    public double[] varianceValue(double[] arr) {
        double mean = meanValue(arr);
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = arr[i] - mean;
        }
        return temp;
    }
    // A method that return an array which contains the squared variance of an array value.
    public double[] squaredVarianceValue(double[] arr) {
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = Math.pow(arr[i], 2);
        }
        return temp;
    }
    // A method that return the standard deviation value.
    public double standardDeviationValue(double[] arr) {
        double[] squaredVarianceValue = squaredVarianceValue(arr);
        return sumValue(squaredVarianceValue)/(squaredVarianceValue.length-1);
    }
    // A method that print an array values.
    public void display(double[] arr) {
        for(double i:arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
