package org.example.BinarySearch;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            ar[i] = sc.nextInt();
        }
//        System.out.println(mySqrt(n));
        findFixedPoint(ar);
    }

    private static void findFixedPoint(int[] ar) {
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left=0; int right=x/2;
        int ans=0;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(mid*mid==x)
                return  mid;
            else if(mid*mid<x){
                ans=mid;
                left=mid+1;
            }
                else
                    right=mid-1;
            }
        return ans;
    }
}
