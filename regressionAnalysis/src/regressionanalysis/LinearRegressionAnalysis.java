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
    /**
     * method that do the calculation and return an array which has the slope\B1 in index 0 and the intercept\B0 in index 1
     * @param yArr
     * @param xArr
     * @return [slope, intercept]
     */
    // Instances variables:
//    private double xSum, ySum, xMean, yMean, xVariance, yVariance, stdDev, b1, b0;
    private double slope, intercept, squaredR;
    
    public double[] getSlopeInterceptValues(double[] yArr, double[] xArr) {
        slopeInterceptCalc(yArr, xArr);
        double[] value = {slope, intercept, squaredR};
        return value;
    }
    public String getFormula() {
        return ("y=" + intercept + "+" + slope + "x");
    }
    private void slopeInterceptCalc(double[] yArr, double[] xArr) {
        double sumXX, sumXY, sumYY;
//        display(xArr);
//        display(yArr);
        double[] xVarianceValue = varianceValue(xArr);
        double[] yVarianceValue = varianceValue(yArr);
        double[] xyVarianceValue = new double[xVarianceValue.length];
//        display(xVarianceValue);
        sumXX = sumValue(squaredArrayValues(xVarianceValue));
        System.out.println("Sxx" + sumXX);
        for(int i=0; i<xyVarianceValue.length; i++) {
            xyVarianceValue[i] = (xVarianceValue[i])*(yVarianceValue[i]);
        }
        sumXY = sumValue(xyVarianceValue);
        System.out.println("Sxy" + sumXY);
        sumYY = sumValue(squaredArrayValues(yVarianceValue));
        System.out.println("Syy" + sumYY);
        slope = sumXY/sumXX;
        intercept = meanValue(yArr) - (slope* meanValue(xArr));
        squaredR = ((Math.pow(sumXY,2))/(sumXX*sumYY));
    }
    // A method that accept an array as an argument and return the sum of values in that array.
    private double sumValue(double[] arr) {
        double sum = 0;
        for(double i:arr){
            sum += i;
        }
        return sum;
    }
    // A method that return the mean of an array values.
    private double meanValue(double[] arr) {
        return sumValue(arr)/arr.length;
    }
    // A method that return an array which contains the variance of an array value.
    private double[] varianceValue(double[] arr) {
        double mean = meanValue(arr);
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = arr[i] - mean;
        }
        return temp;
    }
    // A method that return an array which contains the squared variance of an array value.
    private double[] squaredArrayValues(double[] arr) {
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = Math.pow(arr[i], 2);
        }
        return temp;
    }
    // A method that return the standard deviation value.
    public double standardDeviationValue(double[] arr) {
        double[] squaredVarianceValue = squaredArrayValues(arr);
        return sumValue(squaredVarianceValue)/(squaredVarianceValue.length-1);
    }
    // A method that print an array values.
    private void display(double[] arr) {
        for(double i:arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
