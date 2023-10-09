package org.example;

import java.util.Random;

public class MergeSort {


    public MergeSort (int length){

        Random random = new Random();
        int[] numbers = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }
        System.out.println("Before");
        //printArray(numbers);
        long before = System.currentTimeMillis();
        mergeSort1(numbers);
        long after = System.currentTimeMillis();

        //System.out.println("\nAfter");
        //printArray(numbers);

        System.out.println("\nSpeed is: " + (after - before) / 1000.0);

    }


    private void mergeSort1 (int[] inputArray){
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
        mergeSort1(leftHalf);
        mergeSort1(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }
    private void merge (int [] inputArray, int [] leftSide, int[] rightSide){



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
    private void printArray (int [] number){
        for (int num : number) {
            System.out.println(num);
        }
    }
    private void makeArrayAndSort (int length){

    }

}
