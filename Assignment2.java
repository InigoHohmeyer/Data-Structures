package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    double[][] a = {{1,2,3},{4,5,6},{7,8,9}};
	    double [][] b = {{1,2},{3,4}};
	    System.out.println(Arrays.deepToString(powmatrix(a, 3)));
    }
    public static double pow(double x, double n){
        if(n == 0){
        return 1;}
        else if (n == 1){
            return x;
        }
        else if(n%2 == 1){
            return x * pow(Math.pow(x,2), (n-1)/2);

        }else
            return pow(Math.pow(x,2), n/2);
    }
    public static double[][] multiplymatrices(double [][] a, double[][] b){
        // multiplies two matrices assumes that they are both squares of same dimensions
        double[][] c = new double[a.length][b.length];
        for(int i = 0; i < a.length; i++){
            for(int j =0; j < b.length; j++){
                for(int k = 0; k < b.length; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static double[][] identity(int length){
        //creates an identity matrix
        double [][] c = new double [length][length];
        for(int i = 0; i < c.length; i++ ){
            for(int j = 0; j < c[i].length; j++){
                if(j == i){
                    c[i][j] = 1;
                }else
                    c[i][j] = 0;
            }
        }
        return c;
    }


    public static double [][] powmatrix(double[][] x, int n){
        //creates an identity matrix
        double[][] identity = identity(x.length);
        //Base case if exponent has been reduced to 0 or 1
        if (n == 0){
            // multiplies it by identity or equivalent of 1
        return identity;}
        else if(n == 1){
            //multiplies by the original matrix
            return x;
        }
        else if(n%2 == 1){
            //If n is odd subtracts n by one and divides by two
            return multiplymatrices(x,powmatrix(multiplymatrices(x,x), (n-1)/2));
        }
        else{
            //If is even divides n by two
            return powmatrix(multiplymatrices(x,x), n/2);
        }


    }



}
