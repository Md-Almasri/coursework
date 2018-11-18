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
     * A method that accepts two arguments ,which are the values of y axis and x axis,
     * and invoke another method with two arguments to calculate the slope, intercept and squared R, and then
     * return an array which has the slope\B1 in index 0 and the intercept\B0 in index 1 and the squared R in index[2].
     * @param yAxisValues
     * @param xAxisValues
     * @return DetailedData.
     */
    public static DetailedData getLinear(double[] yAxisValues, double[] xAxisValues) {
        DetailedData  detailedData = new DetailedData();
        detailedData.xAxisValues = xAxisValues;
        detailedData.yAxisValues = yAxisValues;
        detailedData.numOfXs = xAxisValues.length;
        detailedData.numOfYs = yAxisValues.length;
        for(int i = 0; i < yAxisValues.length; i++) {
            detailedData.sumOfXY += (xAxisValues[i] * yAxisValues[i]);
            detailedData.sumOfY += yAxisValues[i];
            detailedData.sumOfX += xAxisValues[i];
            detailedData.sumOfSquaredX += Math.pow(xAxisValues[i], 2);
            detailedData.sumOfSquaredY += Math.pow(yAxisValues[i], 2);;
        }
        detailedData.meanOfY = detailedData.sumOfY / detailedData.numOfYs;
        detailedData.meanOfX = detailedData.sumOfX / detailedData.numOfXs;
        // Call a method to calculate the slop, intercept and squared R.
        slopeInterceptCalc(yAxisValues, xAxisValues, detailedData);
        return detailedData;
    }
    /**
     * A method that accepts three arguments ,which are the values of y axis, x axis and detailed data. 
     * and calculates the intercept, slope and squared R.
     * @param yAxisValues
     * @param xAxisValues
     * @param detailedData
     */
    private static void slopeInterceptCalc(double[] yAxisValues, double[] xAxisValues, DetailedData  detailedData) {
        double[] xDeviations = deviationsFromTheMean(xAxisValues);
        double[] xyDeviations = new double[xDeviations.length];
        detailedData.yDeviations = deviationsFromTheMean(yAxisValues);
        detailedData.yVariance = sumValue(squaredArrayValues(detailedData.yDeviations));
        detailedData.xVariance = sumValue(squaredArrayValues(xDeviations));
        for(int i=0; i<xDeviations.length; i++) {
            xyDeviations[i] = xDeviations[i]*detailedData.yDeviations[i];
        }
        detailedData.xyVariance = sumValue(xyDeviations);
        detailedData.xStdDev = Math.sqrt(detailedData.xVariance / (detailedData.numOfXs - 1));
        detailedData.yStdDev = Math.sqrt(detailedData.yVariance / (detailedData.numOfYs - 1));
        detailedData.slope = detailedData.xyVariance/detailedData.xVariance;
        detailedData.intercept = detailedData.meanOfY - (detailedData.slope* detailedData.meanOfX);
        detailedData.squaredR = ((Math.pow(detailedData.xyVariance,2))/(detailedData.xVariance*detailedData.yVariance));
    }
    // A method that accepts an array as an argument and return the sum of values in that array.
    private static double sumValue(double[] arr) {
        double sum = 0;
        for(double i:arr){
            sum += i;
        }
        return sum;
    }
    // A method that returns the mean of an array values.
    private static double meanValue(double[] arr) {
        return sumValue(arr)/arr.length;
    }
    // A method that returns an array which contains the variance of an array value.
    private static double[] deviationsFromTheMean(double[] arr) {
        double mean = meanValue(arr);
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = arr[i] - mean;
        }
        return temp;
    }
    // A method that returns an array which contains the squared of an array values.
    private static double[] squaredArrayValues(double[] arr) {
        double[] temp = new double[arr.length];
        for(int i = 0; i<temp.length; i++) {
            temp[i] = Math.pow(arr[i], 2);
        }
        return temp;
    }
    // A method that prints an array values for test.
    private static void display(double[] arr) {
        for(double i:arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
