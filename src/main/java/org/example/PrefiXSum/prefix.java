package org.example.PrefiXSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class prefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar[]=new int [n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
//        missingInteger(ar);
//        numSubarraysWithSum(new int[]{1,0,1,0,1},2);
//        subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
//        System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5));
//        System.out.println(minSubarray(new int[]{3,1,4,2},5));
    }




    public int findTheLongestSubstring(String s) {
        Map<String,Integer>map=new HashMap();
        int state[]=new int [5];

        String currState="00000";
        map.put(currState,-1);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                state[0]=(state[0]+1)%2;
            }
            else if(s.charAt(i)=='e'){
                state[1]=(state[1]+1)%2;
            }
            else if(s.charAt(i)=='i'){
                state[2]=(state[2]+1)%2;
            }
            else if(s.charAt(i)=='o'){
                state[3]=(state[3]+1)%2;
            }
            else if(s.charAt(i)=='u'){
                state[4]=(state[4]+1)%2;
            }
            currState="";
            for(int j=0;j<5;j++){
                currState+=state[j];
            }
            if(map.containsKey(currState))
                result=Math.max(result,i-map.get(currState));
            else
                map.put(currState,i);
        }
        return result;
    }

//    https://leetcode.com/discuss/post/5119937/prefix-sum-problems-by-c0d3m-08l9/
public static long wonderfulSubstrings(String word) {
    int n = word.length();
    Map<Integer, Long> map = new HashMap<>();
    int mask = 0;
    map.put(mask, 1L);
    long cnt = 0;
    for(int i=0;i<n;i++) {
        char ch = word.charAt(i);
        mask ^= (1 << (ch - 'a'));
        cnt += map.getOrDefault(mask, 0L);
        for(int bit=0;bit<10;bit++) {
            int bitmask = mask ^ (1 << bit);
            cnt += map.getOrDefault(bitmask, 0L);
        }
        map.put(mask, map.getOrDefault(mask, 0L) + 1L);
    }
    return cnt;
}



    public static int countTriplets(int[] arr) {

        int prefixxorarr[]=new int[arr.length];
        prefixxorarr[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixxorarr[i]=prefixxorarr[i]^arr[i-1];
        }

        int ans=0;
        for(int i=0;i<arr.length;i++){
            for (int k=1;k<arr.length;k++){
                if(prefixxorarr[i]==prefixxorarr[k])
                    ans+=k-i-1;
            }
        }
        return ans;
    }



    public static  int minSubarray(int[] nums, int p) {
        int totalsum=Arrays.stream(nums).sum();
        int target=totalsum%p;
        if(target==0)
            return 0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int currsum=0;
        int min=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            currsum=(currsum+nums[i])%p;
            int find=(currsum-target+p)%p;
            if(map.containsKey(find)){
                min=Math.min(min,i-map.get(find));
            }
            map.put(currsum,i);

        }
        return min;
    }

    public static boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:arr){
            int rem=(i%k+k)%k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        if(map.getOrDefault(0,0)%2!=0)
            return false;
        for(int j=1;j<=k/2;j++){
            int counterhalf=k-j;
            if(map.get(j)!=map.get(counterhalf))
                return false;

        }
        return true;
    }
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) {
                res += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        System.out.println(res);
        return res;

    }

    public static  int minOperations(int[] ar, int x) {
        int k=Arrays.stream(ar).sum()-x;
        int max=Integer.MAX_VALUE;
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
        if(max==Integer.MAX_VALUE)
            return -1;
        return  ar.length-max;

    }
    public static int numSubarraysWithSum(int[] nums, int k) {
        int res=0;
        int curr=0;
        Map<Integer,Integer>hashmap=new HashMap<>();
        hashmap.put(0,1);
        for(int i:nums){
            curr+=i;
            res+=hashmap.getOrDefault(curr-k,0);
            hashmap.put(curr,hashmap.getOrDefault(curr,0)+1);
        }
        return res;
    }

    public static  int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++) {
          if(nums[i]%2==0)
              nums[i]=0;

        }

                int res=0;
        int curr=0;
        Map<Integer,Integer>hashmap=new HashMap<>();
         for(int i:nums){
             curr+=i;
             res+=hashmap.getOrDefault(curr-k,0);
             hashmap.put(curr,hashmap.getOrDefault(curr,0)+1);
         }
         return res;
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int prefixCount[]=new int[words.length+1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int sum=0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (
                    vowels.contains(currentWord.charAt(0)) &&
                            vowels.contains(currentWord.charAt(currentWord.length() - 1))
            ) {
                sum++;
            }
            prefixCount[i] = sum;
        }
        int[] arr1 = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            int ans=prefixCount[right]-(left==0?0:prefixCount[left-1]);
            arr1[i]=ans;
        }
     return arr1;
    }

    private static boolean checkvowels(String word) {
        if ((word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u') &&
                word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u') {
            return  true;
        }
        else
            return  false;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int cummlativeXor[]=new int[arr.length];
        cummlativeXor[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            cummlativeXor[i]=cummlativeXor[i-1]^arr[i];
        }
       int k=0;
        int[] arr1 = new int[arr.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            int xorValue=cummlativeXor[right]^(left==0?0:cummlativeXor[left-1]);
            arr1[i++]=xorValue;
        }
        return arr1;
    }
}

//    public int subarraySum(int[] nums, int k) {
//        int res=0;
//        int curr=0;
//        Map<Integer,Integer>hashmap=new HashMap<>();
//         for(int i:nums){
//             curr+=i;
//             res+=hashmap.getOrDefault(curr-k,0);
//             hashmap.put(curr,hashmap.getOrDefault(curr,0)+1);
//         }
//    }

//    public static int missingInteger(int[] nums) {
//        int ar[]=new int[nums.length];
//        ar[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            ar[i]=ar[i-1]+nums[i];
//        }
//        System.out.println(Arrays.toString(ar));
//        for(int i=0;i<)
//        return  0;
//
//
//    }


