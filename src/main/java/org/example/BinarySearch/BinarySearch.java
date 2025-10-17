package org.example.BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;
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
//        System.out.println(findFixedPoint(ar));
//       System.out.println(FindMaxFromIncreasingDecreasingarray(ar));
//        System.out.println(FirstOccurence(ar,2));
//        System.out.println(LastOccurence(ar,2));
//        System.out.println(RotataedSortedArray(ar));
//        Binary Seacrh condition on array
//        System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10},5));
//        System.out.println(minEatingSpeed(new int[] {3,6,7,11},8));
//        System.out.println(minimumTime(new int[] {1,2,3},5));
//        System.out.println(smallestDivisor(new int[] {44,22,33,11,1},5));

//        System.out.println(minDays(new int[] {7,7,7,7,12,7,7},2 ,3));

//        System.out.println(maxDistance(new int[] {1,2,3,4,7},3));
//        System.out.println(minimumSize(new int[] {8,3,5},3));
        System.out.println(repairCars(new int[] {4,2,3,1},10));
    }
    public static long repairCars(int[] ranks, int cars) {
        long left=Arrays.stream(ranks).min().getAsInt();
        long right=Arrays.stream(ranks).max().getAsInt()*cars*cars;
        long ans=0;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(allcarsrepaired(ranks,mid,cars)){
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return  ans;
    }

    private static boolean allcarsrepaired(int[] ranks, long mid, int cars) {
       long maxcarsreapire=0;
       for(int r:ranks) {
           maxcarsreapire += (long) Math.sqrt(mid / r);
           if (maxcarsreapire >=cars)
               return true;
       }
           return false;

    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int left=1;
        int right= Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(allocatedball(mid,nums,maxOperations)){
            ans=mid;
            right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return  ans;


    }

    private static boolean allocatedball(int mid, int[] nums, int maxOperations) {
        int operation=0;
        for(int n:nums){
            if(n>mid){
                int bag=  (int)Math.ceil(n/(double)mid);
                operation+=bag-1;
            }
            if(operation>maxOperations)
                return  false;
        }
        return  true;
    }

    public static  int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=1;
        int right=position[position.length-1]-position[0];
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(allocatedbasket(mid,position,m)){
                ans=mid;
                left=mid+1;
            }
            else
                right=mid-1;
        }
        return ans;


    }

    private static boolean allocatedbasket(int mid, int[] position, int m) {
        int ballplaced=1;
        int lastpos=position[0];
        for(int i=0;i<position.length;i++){
            if(position[i]-lastpos>=mid)
            {
                ballplaced++;
                lastpos=position[i];

            }
            if(ballplaced>=m)
                return true;
        }
        return  false;
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        int left=1;
        int ans=Integer.MAX_VALUE;
        int right=Arrays.stream(bloomDay).max().getAsInt();
        while(left<=right){
            int mid=left+(right-left)/2;
            int totoaldays=bloomhelper(bloomDay,k,mid);
            if(totoaldays>=m)
            {
                ans=Math.min(ans,mid);
                right=mid-1;
            }
            else
                left=mid+1;
        }

//        for(int i=left;i<=right;i++){
//            int totoaldays=bloomhelper(bloomDay,k,i);
//            if(totoaldays>=m)
//            {
//                ans=Math.min(ans,i);
//            }
//
//        }

        if(ans!=Integer.MAX_VALUE)
            return ans;

            else
                return -1;

    }

    private static int bloomhelper(int[] bloomDay, int k, int i) {
        int kcount=0;
        int count=0;
        for(int bloom:bloomDay){
            if(i>=bloom){
                kcount++;
                if(kcount==k) {
                    count++;
                    kcount=0;
                }
            }
            else{
                kcount=0;
            }
        }
        return count;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            int totatsum=totaldivisior(nums,mid);
            if(totatsum<=threshold)
            {
                right=mid-1;

            }

            else
                left=mid+1;

        }
        return left;

    }

    private static int totaldivisior(int[] nums, int mid) {
        int sum=0;
        for(int n:nums){
            sum+=Math.ceil((double) n / mid);
        }
        return sum;
    }

    public static long minimumTime(int[] time, int totalTrips) {
        long left=1;
        long right=(long) Arrays.stream(time).min().getAsInt() * totalTrips;
        int ans=0;
//        for(long i=left;i<right;i++){
//            long trips = totalTripsCovered(time, i);
//            if(trips<=totalTrips)
//                 ans++;
//        }
//        return ans;
        while(left<right){
            long mid = left + (right - left) / 2;
            long trips = totalTripsCovered(time, mid);

            if (trips >= totalTrips) {
                right = mid;
            } else {

                left = mid + 1;
            }
        }
        return left;

    }

    private static long totalTripsCovered(int[] time, long mid) {
        long totoaltripscovered=0;
        for(int t:time){
            totoaltripscovered+=mid/t;
        }
        return totoaltripscovered;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();
        while(left<=right){
            int mid=(left+right)/2;
            int totalhours=functionhelper(piles,mid);
            if(totalhours<=h)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
//        for(int i=1;i<=right;i++){
//            int totalhours=functionhelper(piles,i);
//            if(totalhours<=h)
//                return i;
//        }
//        return right;
    }

    private static int functionhelper(int[] piles, int k) {
        int totalHours=0;
        for(int pile:piles){
            totalHours += Math.ceil((double) pile / k);
        }
        return totalHours;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left= Arrays.stream(weights).max().getAsInt();
        int right=Arrays.stream(weights).sum();
        int res=0;
        while(left<=right){
            int mid=(left+right)/2;
            int daysRequire=functionFindCapcity(weights,mid);
            if(daysRequire<=days){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return left;
//        for(int i=left;i<right;i++){
//            int daysRequire=functionFindCapcity(weights,i);
//            if(daysRequire<=days){
//                return i;
//            }
//        }
//        return 0;
    }

    private static int functionFindCapcity(int[] weights, int capacity) {
        int days=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days=days+1;
                load = 0;
            }
            load+=weights[i];
        }
        return  days;
    }

    private static boolean SearchInSortedRotatedarray(int[] ar,int target) {
        int pivot=RotataedSortedArray(ar);
        if (pivot == 0) return binarySearch(ar, 0, ar.length - 1, target);
        return binarySearch(ar, 0, pivot - 1, target) || binarySearch(ar, pivot, ar.length- 1, target);
    }
    private static boolean binarySearch(int[] ar, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ar[mid] == target) return true;
            else if (ar[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    private static int RotataedSortedArray(int[] ar) {
        int left=0;int right=ar.length-1;
        while (left<right){
            if (ar[left] <= ar[right]) {
                return left;
            }
            int mid=left+(right-left)/2;
            int next=(mid+1)%ar.length;
            int prev=(mid-1+ar.length)%ar.length;
            if(ar[mid]<ar[next]&&ar[mid]<ar[prev])
                return mid;
            if (ar[left] <= ar[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  0;
    }

    private static int LastOccurence(int[] ar,int target) {
        int res=0;
        int left=0;int right=ar.length-1;
        while(left<right){
            int mid = left + (right - left) / 2;
            if(ar[mid]==target){
                res=mid;
                left=mid+1;
            }
            else if(ar[mid]>target){
                right=mid-1;
            }
            else
                left=mid+1;

        }
        return res;
    }

    private static int FirstOccurence(int[] ar,int target) {
        int res=0;
        int left=0;int right=ar.length-1;
        while(left<right){
            int mid = left + (right - left) / 2;
            if(ar[mid]==target){
                res=mid;
                right=mid-1;
            }
            else if(ar[mid]>target){
                right=mid-1;
            }
            else
                left=mid+1;

        }
        return res;
    }


    private static int FindMaxFromIncreasingDecreasingarray(int[] ar) {
        if (ar.length == 1) return ar[0];
        if (ar.length == 2) return Math.max(ar[0], ar[1]);

        int left = 1;
        int right = ar.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ar[mid] >= ar[mid - 1] && ar[mid] >= ar[mid + 1]) {
                return ar[mid]; // found peak
            } else if (ar[mid] < ar[mid + 1]) {
                left = mid + 1; // go right (increasing slope)
            } else {
                right = mid - 1; // go left (decreasing slope)
            }
        }

        // After loop, left > right.
        // The peak will be at left or right (one of them is valid).
        return Math.max(ar[left], ar[right]);
    }

    private static int findFixedPoint(int[] ar) {
        int left=0;
        int right=ar.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid==ar[mid])
                return mid;
            else if(ar[mid]<mid)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
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
