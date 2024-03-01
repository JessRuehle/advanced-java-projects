package edu.bloomu.homework1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a matrix of a size determined by user with default values of 0. Has methods
 * that allows user to insert values
 */
public class Matrix {

    private final int columns; //number of columns in the matrix
    private final int rows; //number of rows in the matrix
    double[][] numbers; //2d array containing all the numbers of the matrix

    // constructor to create a new instance of Matrix that takes arguments for the
    // number of rows and columns it should have
    public Matrix(int rows, int columns) {

        // assign the user's rows and columns values to the class variables
        this.rows = rows;
        this.columns = columns;

        // the array to contain the data of the matrix
        numbers = new double[rows][columns];

        // for loop to assign all the values in the data set to 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numbers[i][j] = 0;
            }
        }
    }

    /*
    setEntry method allows user to input a value into a specific index in the array of
    the Matrix
     */
    public void setEntry(int r, int c, double value) {
        numbers[r][c] = value;
    }

    /*
    equals method allows user to compare the size and data of one Matrix to another and
    determine if they are the same.
     */
    public boolean equals(Matrix otherMatrix) {

        // if statement to check if both matrices have the same number of rows and
        // columns, and returns false if not
        if (otherMatrix.rows != this.rows || otherMatrix.columns != this.columns) {
            return false;
        }

        // once the dimensions of the matrices have been checked, these for loops
        // iterate through the array to determine if the value at each of the indices
        // are equal and returns false if at any point they aren't
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (numbers[i][j] != otherMatrix.numbers[i][j]) {
                    return false;
                }
            }
        }

        // if both the size and contents of the two matrices are equal, the method will
        // return true
        return true;
    }

    /*
    Add method allows user to add the contents of two arrays as long as they have the
    same dimensions
     */
    public Matrix add(Matrix otherMatrix) throws DimensionMismatch {

        // if the matrices are equal in size, then proceed with the addition
        if (otherMatrix.rows == this.rows && otherMatrix.columns == this.columns) {

            // first, create a new matrix to contain the sums of the addition
            Matrix sum = new Matrix(rows, columns);

            // then, using a for loop, add the values at the corresponding indices in
            // each matrix and assign that value to the same index in the new one
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum.numbers[i][j] = numbers[i][j] + otherMatrix.numbers[i][j];
                }
            }

            // if all the addition was able to take place, the summed matrix will be
            // returned
            return sum;
        }

        throw new DimensionMismatch("Dimenstions do not match");
    }

    /*
    Subtract method allows user to subtract the contents of two arrays as long as they
    have the same dimensions
     */
    public Matrix subtract(Matrix otherMatrix) throws DimensionMismatch{

        // if the matrices are equal in size, then proceed with the addition
        if (otherMatrix.rows == this.rows && otherMatrix.columns == this.columns) {

            // first, create a new matrix to contain the sums of the addition
            Matrix sum = new Matrix(rows, columns);

            // then, using a for loop, add the values at the corresponding indices in
            // each matrix and assign that value to the same index in the new one
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum.numbers[i][j] = numbers[i][j] - otherMatrix.numbers[i][j];
                }
            }

            // if all the addition was able to take place, the summed matrix will be
            // returned
            return sum;
        }

        throw new DimensionMismatch("Dimenstions do not match");
    }

    public Matrix multiply(Matrix otherMatrix) throws DimensionMismatch{

        // first, check to make sure the number of rows in the first matrix matches the
        // number of columns in the second matrix, and vice versa
        if (columns == otherMatrix.rows && rows == otherMatrix.columns) {

            // create a new matrix to contain the data of the multiplied matrices
            Matrix total = new Matrix(columns, otherMatrix.rows);

            // iterate through the two matrices
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < otherMatrix.columns; j++) {

                    // this doubles tracks the sum of the multiplication
                    double sum = 0;
                    for (int k = 0; k < columns; k++) {
                        sum += numbers[i][k] * otherMatrix.numbers[k][j];
                    }
                    // set the entry at the correct index in the new matrix to the sum
                    total.setEntry(i, j, sum);
                }
            }
            // return the matrix with the totals
            return total;
        }
        // throw an exception if the number of rows in the first matrix don't match the
        // amount of columns in the second matrix, and vice versa
        throw new DimensionMismatch("Row count of Matrix does not " +
                "match column count of Matrix being multiplied by");
    }

    public Matrix transpose() {
        Matrix transposed = new Matrix(columns, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed.numbers[i][j] = numbers[j][i];
            }
        }

        return transposed;
    }


    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                output += numbers[i][j] + " ";
            }
            output += "\n";
        }

        return output;
    }



}
