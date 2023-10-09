package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //StringHiding("Samer");
        //BMI();
        //makeArrayAndSort(1000); // O(n log n)
    }
    public static void StringHiding(String name){
        Scanner scan = new Scanner(System.in);

        List<Character> makeLines = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            makeLines.add('_');
        }
        System.out.println("Enter a letter or guess the full name of " + name.length() + " letters: ");

        char[] nameLetters = name.toLowerCase().toCharArray();

        while (true) {

            String input = scan.next();
            if (input.equalsIgnoreCase("exit")) System.exit(0);
            if (input.equalsIgnoreCase(name)) {
                System.out.println("You got it: " + name);
                break;
            }
            boolean tellItsWrong = true;

            char inputChar = input.charAt(0);
            for (int i = 0; i < nameLetters.length; i++) {
                if (inputChar == nameLetters[i]) {
                    makeLines.set(i, inputChar);
                    tellItsWrong = false;
                }
            }
            if (tellItsWrong) System.out.println("Wrong! Try again");

            StringBuilder toPrint = new StringBuilder();

            for (char letterToPrint : makeLines) {
                toPrint.append(letterToPrint);
            }
            if (toPrint.toString().equalsIgnoreCase(name)) {
                System.out.println("You got it: " + name);
                break;
            }
            for (int i = 0; i < toPrint.length(); i++) {
                System.out.print(toPrint.charAt(i) + " ");
            }
            System.out.println();
        }
    }
    public static void BMI (){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = input.nextDouble();
        System.out.print("Enter your height in centimeters: ");
        double height = input.nextDouble();
        height = height / 100.0;
        double bmi = weight / (height * height);
        System.out.println("Your BMI is: " + bmi);

        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal weight");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("BMI Category: Overweight");
        } else {
            System.out.println("BMI Category: Obesity");
        }
        input.close();
    }
    public static void mergeSort (int[] inputArray){
        int inputLength = inputArray.length;
        if (inputLength < 2) return;

        int mid = inputLength / 2;

        int [] leftHalf = new int[mid];
        int [] rightHalf = new int[inputLength - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = mid; i < inputLength; i++) {
            rightHalf[i - mid] = inputArray[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }
    public static void merge (int [] inputArray, int [] leftSide, int[] rightSide){



        int left = leftSide.length;
        int right = rightSide.length;

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (leftSide[i] <= rightSide[j]) {
                inputArray[k] = leftSide[i];
                i++;
            } else {
                inputArray[k] = rightSide[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            inputArray[k] = leftSide[i];
            i++;
            k++;
        }
        while (j < right) {
            inputArray[k] = rightSide[j];
            j++;
            k++;
        }
    }
    public static void printArray (int [] number){
        for (int num : number) {
            System.out.println(num);
        }
    }
    public static void makeArrayAndSort (int length){
        Random random = new Random();
        int[] numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }
        System.out.println("Before");
        //printArray(numbers);
        long before = System.currentTimeMillis();
        mergeSort(numbers);
        long after = System.currentTimeMillis();

        //System.out.println("\nAfter");
        //printArray(numbers);

        System.out.println("\nSpeed is: " + (after - before) / 1000.0);
    }
}