package com.alg.sort;

public class QuickSort {

    public static void main(String[] args) {
        int [] a = {1,6,8,7,3,5,16,4,8,36,13,44};
        sort(a ,0 ,a.length - 1);
    }

    public static void sort(int[] a ,int start ,int end){
        if (a == null || a.length == 0){
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left--;
            }
            a[right] = a[left];
         }
        a[left] = temp;
        sort(a, start, left -1);
        sort(a,left+1,end);



    }
}
