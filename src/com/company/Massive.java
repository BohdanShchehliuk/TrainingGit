package com.company;
import java.util.Scanner;

public class Massive {

    public static int[] massive(int n) {
        int massive[] = new int[n];
        for (int i = 0; i < n; i++) {
            massive[i] = (int) (Math.random() * 100);
            System.out.print(massive[i] + " ");
        }
        return massive;
    }

    public static int[][] massive(int a, int b) {
        int massive[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            massive[i] = new int[b];
            for (int k = 0; k < b; k++) {
                massive[i][k] = (int) (Math.random() * 100);
            }
        }

        return massive;
    }

    public static String operation(int[] massive) {
        int max = massive[0];
        int min = massive[0];
        double sum = 0;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] > max) {
                max = massive[i];
            }
            if (massive[i] < min) {
                min = massive[i];
            }
            sum = sum + massive[i];
            System.out.print(massive[i] + " ");
        }
        return "\nМаксимальне число одновимірного масиву є: " + max + ". Мінімальне число: " + min +
                ". Сума чисел: " + sum + ". Cереднє значення чисел є: " + sum / massive.length;
    }

    public static String operation(int[][] massive) {
        int max = massive[0][0];
        int min = massive[0][0];
        int number =0;
        double sum = 0;

        for (int i = 0; i < massive.length; i++) {
            for (int k = 0; k < massive[i].length; k++) {
                if (massive[i][k] > max) {
                    max = massive[i][k];
                }
                if (massive[i][k] < min) {
                    min = massive[i][k];
                }
                sum = sum + massive[i][k];
                System.out.print(massive[i][k] + " ");
            }
            System.out.println("");
            number++;
        }
        return "Максимальне число двохвимірного масиву є: " + max + ". Мінімальне число: " + min +
                ". Сума чисел: " + sum + ". Cереднє значення чисел є: " + sum / number;
    }

    public static void main(String[] arg) {
        System.out.println("Введіть розмір одновимірного масиву n:");
        Scanner input = new Scanner(System.in);
        int numberOneDimensionMassive = input.nextInt();
        input = new Scanner(System.in);

        System.out.println(operation(massive(numberOneDimensionMassive)));

        System.out.println("\nВведіть розміри двохвимірного прямокутного масиву а*b:");
        int numberOfRows = input.nextInt();
        input = new Scanner(System.in);
        int numberOfColums = input.nextInt();

        System.out.println(operation(massive(numberOfRows, numberOfColums)));
    }
}
