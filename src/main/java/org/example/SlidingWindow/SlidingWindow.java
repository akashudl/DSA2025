package org.example.SlidingWindow;

import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int ar[]=new int[n];
        for (int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
//        System.out.println(maxSubArray(ar,k));

//        FirstNegativeNumber(ar,k);
          //maxSlidingWindow(ar,k);
       //   CountOccurencesOfanagram(sc);
//        findMaxAverage(ar,k);
//        maxKDistinct(ar,k);
//
//        maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3);
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
//    public static int[] maxKDistinct(int[] nums, int k) {
//        int ar[]=new int[k];
//        HashSet<Integer>set=new HashSet<>();
//    }


    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map=new HashMap<>();
        int i=0;int j=0;int n=s.length();
        StringBuilder ans=new StringBuilder();
        while(j<s.length()){
            ans.append(s.charAt(j));
            if(j-i+1<10){
//                AAAAACCCCC -> {Integer@1034} 1
                j++;
            }
            else if(j-i+1==10){
                String seq = ans.toString();
                map.put(seq,map.getOrDefault(seq,0)+1);

              ans.deleteCharAt(0);
                i++;
                j++;
            }
        }
        ArrayList<String>al=new ArrayList<>();
        for(Map.Entry<String,Integer>m:map.entrySet()){
            if(m.getValue()>1){
                al.add(m.getKey());
            }
        }
        System.out.println(al);
       return al;

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int notgrumpcustmer=0;
        int maxGrumphCustomer=Integer.MIN_VALUE;
        int i=0;int j=0;int grumphyCustomersum=0;
        while(j<customers.length){
            if(grumpy[j]==0)
            {
                notgrumpcustmer+=customers[j];
            }
            else if(grumpy[j]!=0){
                grumphyCustomersum+=customers[j];
            }
            if(j-i+1==minutes){
                maxGrumphCustomer=Math.max(grumphyCustomersum,maxGrumphCustomer);
                if(grumpy[i]==1){
                    grumphyCustomersum-=customers[i];

                }
                i++;
            }
            j++;
        }

        return maxGrumphCustomer+notgrumpcustmer;

        }
    public static double findMaxAverage(int[] nums, int k) {
        int i=0 ,j=0,sum=0;
        double maxavg=Integer.MIN_VALUE;
        while(j<nums.length){

            sum+=nums[j];
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
                double temp=(sum/(double)k);
                maxavg=Math.max(temp,maxavg);
                sum=sum-nums[i];
                i++;
                j++;
            }
        }
        System.out.println(maxavg);
        return  maxavg;

    }

    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hashMap =new HashMap<>();
        int i=0;int j=0;long maxSum=0;int sum=0;
        while(j<nums.length){
            hashMap.put(nums[j],hashMap.getOrDefault(nums[j],0)+1);
            sum+=nums[j];
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
            if (hashMap.size()==k)
                maxSum=Math.max(maxSum,sum);
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)-1);
            if(hashMap.get(nums[i])==0)
            {
                hashMap.remove(nums[i]);
            }
            sum-=nums[i];
                i++;
                j++;
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    private static void CountOccurencesOfanagram(Scanner sc) {
        String s=sc.nextLine();
        String pat=sc.nextLine();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<pat.length();i++){
            if(map.containsKey(pat.charAt(i))){
                map.put(pat.charAt(i),map.get(pat.charAt(i))+1);
            }
            else{
                map.put(pat.charAt(i),1);
            }

        }
        int count=map.size();
        int k=pat.length();
        int j=0;int i=0;int ans=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))==0){
                    count--;
                }
            }
            if (j-i+1<k){
                j++;
            }
            else if (j-i+1==k) {
                if(count==0){
                    ans++;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i)) == 1) count = count + 1;

                }
                i++;
                j++;

            }

        }
        System.out.println(ans);


    }




    public static void maxSlidingWindow(int[] nums, int k) {
//        if(nums.length==1)
//            return nums;
        Deque<Integer> dq=new LinkedList<>();
        int ar[]=new int [nums.length-k+1];
        int i=0;int j=0;int max=nums[0];
        while(j<nums.length){
            while(dq.size()>0 && nums[j]> dq.getLast())
            {
                dq.pollLast();

            }
            dq.offerLast(nums[j]);
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
                ar[i]=dq.peekFirst();
                if (!dq.isEmpty() && dq.peekFirst() == nums[i]) {
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(ar));

    }

    private static void FirstNegativeNumber(int[] ar, int k) {
        int i=0;
        int j=0;
        int newAr[]=new int[ar.length-k+1];
        int negativeNumber=0;
        Queue<Integer> al=new LinkedList<>();
        while(j<ar.length){
            if(ar[j]<0){
                al.add(ar[j]);
            }
            if(j-i+1<k)
                j++;
            else if(j-i+1==k){
                if(al.size()==0)
                    System.out.print(0+" ");
                else {
                    System.out.print(al.peek()+" ");
                    if(ar[i]==al.peek())
                    {
                        al.poll();
                    }

                }
                i++;
                j++;
            }
        }

    }


    public static int maxSubArray(int[] nums,int k) {
       int i=0;
       int j=0;
       int sum=0;
       int max=Integer.MIN_VALUE;
       while(j<nums.length){
           sum+=nums[j];
           if(j-i+1<k)
           {
               j++;
           }
           else if(j-i+1==k){
               max=Math.max(max,sum);
               sum=sum-nums[i];
               i++;
               j++;
           }

       }
       return max;
    }
}
