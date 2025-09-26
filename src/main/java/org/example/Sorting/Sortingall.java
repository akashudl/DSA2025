package org.example.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Sortingall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar[]=new int [n];
        for(int i=0;i<ar.length;i++){
            ar[i]=sc.nextInt();
        }
        //BubbleSort(ar,n);
//        SelectionSort(ar,n);
//        InsertionSort(ar,n);
        //MergeSort(ar,0,ar.length-1);
        QuickSort(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ar));
    }

    private static void QuickSort(int[] ar, int left, int right) {
        
        if(left<right){
            int pivotindex=partition(ar,left,right);
            QuickSort(ar,left,pivotindex-1);
            QuickSort(ar,pivotindex+1,right);
        }
    }

    private static int partition(int[] ar, int left, int right) {
        int idx=left-1;
        int pivot=ar[right];
        for(int i=left;i<=right;i++){
            if(ar[i]<pivot){
                idx=idx+1;
                int temp=ar[idx];
                ar[idx]=ar[i];
                ar[i]=temp;
            }
        }
        idx++;
        int temp=ar[idx];
        ar[idx]=ar[right];
        ar[right]=temp;
        return idx;

    }

    private static void MergeSort(int[] ar,int left,int right) {
        if(left>=right)
        {
            return ;
        }
        int mid=left+(right-left)/2;
        MergeSort(ar,left,mid);
        MergeSort(ar,mid+1,right);
        MergeSorrtedArray(ar,left,mid,right);

    }

    private static void MergeSorrtedArray(int arr[],int left,int mid,int right) {
        int nums1[]=new int[mid-left+1];
        for(int i=0;i<nums1.length;i++){
            nums1[i]=arr[left+i];
        }
        int  nums2[]=new int[right-mid];
        for(int i=0;i<nums2.length;i++){
            nums2[i]=arr[mid+i+1];
        }
        int i=0;int j=0; int k=left;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                arr[k]=nums1[i];
                i++;
                k++;
            }
            else if(nums2[j]<=nums1[i]){
                arr[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while (j<nums2.length){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        return;
    }

    private static void InsertionSort(int[] ar, int n) {
        for(int i=0;i<n;i++){
            int currvalue=ar[i];
            int j=i-1;
            while(j>=0&&ar[j]>currvalue){
                ar[j+1]=ar[j];
                j--;
            }
            ar[j+1]=currvalue;
        }
        System.out.println(Arrays.toString(ar));
    }

    private static void SelectionSort(int[] ar, int n) {
        for(int i=0;i<n;i++){
            int minindex=i;
            for(int j=i;j<n;j++){
                if(ar[j]<ar[minindex]){
                    minindex=j;
                }
            }
            int temp=ar[i];
            ar[i]=ar[minindex];
            ar[minindex]=temp;

        }
        System.out.println(Arrays.toString(ar));
    }

    private static void BubbleSort(int[] ar, int n) {
        boolean alreadysortedarray=false;
        for(int i=0;i<n-1;i++){
            // Stooping bubble sort for best case
            for(int j=0;j<n-1-i;j++){
                if(ar[j]>ar[j+1])
                {
                    alreadysortedarray=true;
                    int temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                }
                if(!alreadysortedarray)
                    break;
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
