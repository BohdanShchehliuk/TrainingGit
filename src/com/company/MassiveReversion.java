package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MassiveReversion {

    public static int[] fillMassiveOne(int[] massive, int numberOneDimensionMassive) {

        if (numberOneDimensionMassive == 0)
            return massive;
        else {
            massive[numberOneDimensionMassive - 1] = (int) (Math.random() * 100);
        }
        return fillMassiveOne(massive, numberOneDimensionMassive - 1);
    }

    public static int[][] fillMassiveTwo(int[][] massive, int numberOfRows, int numberOfColums) {
        if (numberOfRows == 0) {
            return massive;
        } else if (numberOfColums == 0) {
            fillMassiveTwo(massive, numberOfRows - 1, (massive[numberOfRows - 1].length));
            return massive;
        } else
            massive[numberOfRows - 1][numberOfColums - 1] = (int) (Math.random() * 100);
        fillMassiveTwo(massive, numberOfRows, numberOfColums - 1);
        numberOfColums--;
        return massive;
    }

    public static int operationМax(int[] massive, int numberOneDimensionMassive, int max) {
        if (numberOneDimensionMassive == 0) {
            return max;
        } else {
            if (massive[numberOneDimensionMassive - 1] > max) {
                max = massive[numberOneDimensionMassive - 1];
            }
            return operationМax(massive, numberOneDimensionMassive - 1, max);

        }
    }

    public static int operationМax(int[][] massiveTwo, int numberOfRows, int numberOfColums, int max) {

        if (numberOfRows < massiveTwo.length) {
            if (numberOfColums < massiveTwo[numberOfRows].length) {
                if (massiveTwo[numberOfRows][numberOfColums] > max) {
                    max = massiveTwo[numberOfRows][numberOfColums];
                }
                return operationМax(massiveTwo, numberOfRows, ++numberOfColums, max);
            } else {
                numberOfColums = 0;
                return operationМax(massiveTwo, ++numberOfRows, numberOfColums, max);
            }
        }
        return max;
    }


    public static int operationSum(int[][] massiveTwo, int numberOfRows, int numberOfColums, int sum) {

        if (numberOfRows < massiveTwo.length) {
            if (numberOfColums < massiveTwo[numberOfRows].length) {

                sum = sum+massiveTwo[numberOfRows][numberOfColums];
                return operationSum(massiveTwo, numberOfRows, ++numberOfColums, sum);
            } else {
                numberOfColums = 0;
                return operationSum(massiveTwo, ++numberOfRows, numberOfColums, sum);
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println("Введіть розмір одновимірного масиву n:");
        Scanner input = new Scanner(System.in);
        int numberOneDimensionMassive = input.nextInt();
        input = new Scanner(System.in);
        int[] massive = new int[numberOneDimensionMassive];

        System.out.println(Arrays.toString(fillMassiveOne(massive, numberOneDimensionMassive)));
        System.out.println(operationМax(massive, numberOneDimensionMassive, massive[numberOneDimensionMassive - 1]));


        System.out.println("\nВведіть розміри двохвимірного прямокутного масиву а*b:");
        int numberOfRows = input.nextInt();
        input = new Scanner(System.in);
        int numberOfColums = input.nextInt();
        int[][] massiveTwo = new int[numberOfRows][numberOfColums];
        System.out.println(Arrays.deepToString(fillMassiveTwo(massiveTwo, numberOfRows, numberOfColums)));
        System.out.println(operationМax(massiveTwo, 0, 0, (massiveTwo[0][0])));
        System.out.println(operationSum(massiveTwo, 0, 0, 0));
    }
}
