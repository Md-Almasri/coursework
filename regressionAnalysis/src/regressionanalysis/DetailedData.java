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
public class DetailedData {
    protected double[] yAxisValues,xAxisValues;
    protected int numOfXs, numOfYs;
    protected double meanOfX, meanOfY;
    protected double[] yDeviations;
    protected double xVariance, yVariance, xyVariance;
    protected double xStdDev, yStdDev, sumOfX, sumOfY, sumOfSquaredX, sumOfSquaredY, sumOfXY;
    protected double slope, intercept, squaredR;
}
