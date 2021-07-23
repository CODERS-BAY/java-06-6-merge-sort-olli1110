package com.company;
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void merge(int[] arr, int lArr, int mid, int rArr) {
        int[] leftArray= new int[mid - lArr + 1];
        int[]  rightArray= new int[rArr - mid];
        int leftIndex = 0;
        int rightIndex = 0;

        System.arraycopy(arr, lArr, leftArray, 0, leftArray.length);
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = arr[mid + i + 1];


        // Copying from leftArray and rightArray back into array
        for (int i = lArr; i < rArr + 1; i++) {

            // If there are still elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }

                // If all elements have been copied from rightArray, copy rest of leftArray
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;

                // If all elements have been copied from leftArray, copy rest of rightArray
            } else if (rightIndex < rightArray.length) {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
    //function for sorting the array
    public static void Sort(int[] arr, int low, int high) {
        if (high <= low) return;

        int mid = (low+high)/2;
        Sort(arr, low, mid);
        Sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    // sorting and giving out the array
    public static void main(String[] args) {
        int[] array = new int[10];
        int max = 50;
        int min = 0;
        int range = max - min;
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * range);
        }
        Sort(array, 0, array.length -1);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
