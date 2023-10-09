package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //new MergeSort(1000); // O(n log n)

        //new StringHiding("Samer");

        //new BMI();

        int [] numbers = {1,3};
        int [] result =  searchRange(numbers, 1);
        for (int number1 : result) {
            System.out.println(number1);
        }

    }
    public static int[] searchRange(int[] nums, int target) {

        //Problem is marked as medium in leetCod (Find first and last position element in sorted array)
        // It was accepted but the Runtime is garbage
        // 1ms
        // Beats 21.02%of users with Java

        int[] result = new int[2];

        int length = 0;
        int[] result1;

        if (nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    length++;
                }
            }
            if (length == 0) {
                result[0] = -1;
                result[1] = -1;
                return result;
            }

            result1 = new int[length];
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    result1[j] = i;
                    j++;
                }
            }

            if (result1.length <= 1) {
                result[0] = result1[0];
                result[1] = result1[0];
            } else {
                result[0] = result1[0];
                result[1] = result1[result1.length - 1];
            }
            return result;
        }
    }

    public static int[] searchRangeChatGPT (int[] nums, int target) {

        //This was that fastest solution letCode has ever seen.
        // 0ms
        // Beats 100.00%of users with Java


        int[] result = new int[2];
        result[0] = findFirstOccurrence(nums, target);
        result[1] = findLastOccurrence(nums, target);
        return result;
    }

    private static int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}