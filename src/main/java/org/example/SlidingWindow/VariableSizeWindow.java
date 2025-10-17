package org.example.SlidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VariableSizeWindow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        String s= sc.nextLine();
        int k=sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }

//        LargestSubArraySum(ar,k);
//          LongestSubstring(s,k);
//          LongestSubstringUnique(s);
//          totalFruits(ar);

//        System.out.println(numSubarrayProductLessThanK(ar,k));
        //System.out.println(subarraysWithKDistinct(ar,k));
        System.out.println(longestSubarray(new int[]{5,2,7,9,16}));
    }
    public static int longestSubarray(int[] nums) {
        int j=2;
        int len=2;
        int maxlength=2;
        while(j<nums.length){
            if(nums[j]==(nums[j-1]+nums[j-2])){
                len++;
            }else{
                maxlength=Math.max(maxlength,len);
                len=2;
            }
            j++;
        }
        maxlength = Math.max(maxlength, len);
        return maxlength;
    }



    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }



    public static int atMostK(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        int i=0;int j=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }


                count+=j-i+1;
            j++;
        }
        return  count;

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)
            return 0;

        int product=1;
        int count=0;
        int i=0;int j=0;
        while(j<nums.length){
            product*=nums[j];
            while(product>=k){
                product=product/nums[i];
                i++;
            }
            if(product<k){
            count+=j-i+1;
            j++;
            }
        }
        return  count;
    }
    public static int totalFruits(int[] fruits) {
        if(fruits.length<=1)
            return fruits.length;
        int k=2;
        HashMap<Integer,Integer>map =  new HashMap<>();
        int i=0;int j=0; int ans=0;
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>k){
                if(map.containsKey(fruits[i])){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i])==0){
                        map.remove(fruits[i]);
                    }
                }
                i++;

            }
               ans=Math.max(j-i+1,ans);
               j++;
        }
        System.out.println(ans);
        return ans;

    }

    private static void LongestSubstringUnique(String s) {
        HashMap<Character,Integer>map =  new HashMap<>();
        int i=0;int j=0; int ans=0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()<j-i+1){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                }
                i++;

            }
            if (map.size()==j-i+1) {
                ans=Math.max(j-i+1,ans);
            }
            j++;
        }
        System.out.println(ans);
    }

    private static void LongestSubstring(String s,int k) {

        HashMap<Character,Integer>map =  new HashMap<>();
        int i=0;int j=0; int ans=0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()>k){
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                        if(map.get(s.charAt(i))==0){
                            map.remove(s.charAt(i));
                        }
                    }
                       i++;

                }
                if (map.size()==k) {
                    ans=Math.max(j-i+1,ans);
                }
            j++;
        }
        System.out.println(ans);

    }

    private static void LargestSubArraySum(int[] ar, int k) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int i=0;int j=0;
        while(j<ar.length){
            sum=sum+ar[j];
            if(sum<k) {
                j++;
            }
            else if (sum==k){
                max=Math.max((j-i+1),max);
                j++;
            }
            else if(sum>k){
                while(sum>k){
                    sum=sum-ar[i];
                    i++;
                }
                if(sum==k)
                    max=Math.max((j-i+1),max);;
                j++;


            }

        }
        System.out.println(max);
    }
}
