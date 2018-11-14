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
    private double slope, intercept, squaredR;
    // !!!!!!It is important to add some check when the y axis values are changed, so we need to invoke getSlopeInterceptSquaredrValues with two parameters.
    private double meanOfAllTheYValues, sumOfSquaresOfYY;
    private double[] yVarianceValue;
    /**
     * A method that accepts two arguments ,which are the values of y axis and x axis,
     * and invoke another method with two arguments to calculate the slope, intercept and squared R, and then
     * return an array which has the slope\B1 in index 0 and the intercept\B0 in index 1 and the squared R in index[2].
     * @param yArr
     * @param xArr
     * @return [slope, intercept, squaredR].
     */
    public double[] getSlopeInterceptSquaredrValues(double[] yArr, double[] xArr) {
        slopeInterceptCalc(yArr, xArr);
        double[] value = {slope, intercept, squaredR};
        return value;
    }
    /**
     * A method that returns a string which is the formula.
     * @return "y=" + intercept + "+" + slope + "x"
     */
    public String getFormula() {
        return ("y=" + intercept + "+" + slope + "x");
    }
    /**
     * A method that accepts two arguments ,which are the values of y axis and x axis, 
     * and calculates the intercept, slope and squared R.
     * @param yArr
     * @param xArr 
     */
    private void slopeInterceptCalc(double[] yArr, double[] xArr) {
        double sumOfSquaresOfXX, sumOfSquaresOfXY;
//        display(yArr);
        meanOfAllTheYValues = meanValue(yArr);
        yVarianceValue = varianceValue(yArr);
        sumOfSquaresOfYY = sumValue(squaredArrayValues(yVarianceValue));
        double[] xVarianceValue = varianceValue(xArr);
        double[] xyVarianceValue = new double[xVarianceValue.length];
        sumOfSquaresOfXX = sumValue(squaredArrayValues(xVarianceValue));
//        System.out.println("Sxx " + sumOfSquaresOfXX);
        for(int i=0; i<xyVarianceValue.length; i++) {
            xyVarianceValue[i] = (xVarianceValue[i])*(yVarianceValue[i]);
        }
        sumOfSquaresOfXY = sumValue(xyVarianceValue);
        slope = sumOfSquaresOfXY/sumOfSquaresOfXX;
        intercept = meanOfAllTheYValues - (slope* meanValue(xArr));
        squaredR = ((Math.pow(sumOfSquaresOfXY,2))/(sumOfSquaresOfXX*sumOfSquaresOfYY));
    }
    public double[] getSlopeInterceptSquaredrValues(double[] xArr) {
        slopeInterceptCalc(xArr);
        double[] value = {slope, intercept, squaredR};
        return value;
    }
    private void slopeInterceptCalc(double[] xArr) {
        double sumOfSquaresOfXX, sumOfSquaresOfXY;
        double[] xVarianceValue = varianceValue(xArr);
        double[] xyVarianceValue = new double[xVarianceValue.length];
        sumOfSquaresOfXX = sumValue(squaredArrayValues(xVarianceValue));
        for(int i=0; i<xyVarianceValue.length; i++) {
            xyVarianceValue[i] = (xVarianceValue[i])*(yVarianceValue[i]);
        }
        sumOfSquaresOfXY = sumValue(xyVarianceValue);
        slope = sumOfSquaresOfXY/sumOfSquaresOfXX;
        intercept = meanOfAllTheYValues - (slope* meanValue(xArr));
        squaredR = ((Math.pow(sumOfSquaresOfXY,2))/(sumOfSquaresOfXX*sumOfSquaresOfYY));
    }
    // A method that accepts an array as an argument and return the sum of values in that array.
    private double sumValue(double[] arr) {
        double sum = 0;
        for(double i:arr){
            sum += i;
        }
        return sum;
    }
    // A method that returns the mean of an array values.
    private double meanValue(double[] arr) {
        return sumValue(arr)/arr.length;
    }
    // A method that returns an array which contains the variance of an array value.
    private double[] varianceValue(double[] arr) {
        double mean = meanValue(arr);
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = arr[i] - mean;
        }
        return temp;
    }
    // A method that returns an array which contains the squared variance of an array value.
    private double[] squaredArrayValues(double[] arr) {
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = Math.pow(arr[i], 2);
        }
        return temp;
    }
    // A method that returns the standard deviation value.
    public double standardDeviationValue(double[] arr) {
        double[] squaredVarianceValue = squaredArrayValues(arr);
        return sumValue(squaredVarianceValue)/(squaredVarianceValue.length-1);
    }
    // A method that prints an array values.
    private void display(double[] arr) {
        for(double i:arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
