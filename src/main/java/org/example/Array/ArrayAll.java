package org.example.Array;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayAll {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k=sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
            {
                ar[i] = sc.nextInt();
            }
//        System.out.println(maxKDistinct(ar,k));
            //LargestElementArray(ar);
            //ScondLargestandSecondSmallest(ar);
            //	GivenArraySorted(ar);
            //	FindUnique(ar);
            //	Rotatearrayone(ar);
            //	RotatearraybyDplace(ar);
            //	Check(n);
         //   MovingZeroToEnd(ar);
        // RemoveDuplicates(ar);
//          RemoveElement(ar,sc);
//          ReverseString(sc);
//          BestTimeToBuySellStock(n,ar);
//        MergeSorrtedArray(sc);
            //MaxConsecutiveOne(ar);
         //   MissingNumber(ar,n);
//            SingleNumber(ar,n);
//        System.out.println( minOperations(ar));

//        System.out.println(gcdOfOddEvenSums(n));
//
//        int cols = sc.nextInt();
//        int rows = sc.nextInt();
//        int[][] arr = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(earliestTime(arr));
//        System.out.println(maxTotalValue(ar,k));
//        maxFrequencyElements(ar);
//        System.out.println(  rangeSum(ar,ar.length,3,4));
//        System.out.println(  sumDivisibleByK(new int [] {1,2,2,3,3,3,3,4},2));
        System.out.println(  longestBalanced(new int [] {2,5,4,3}));
        }

    public static int longestBalanced(int[] nums) {
        int n=nums.length;
        int maxans=0;
        for(int i=0;i<n;i++){
            HashSet<Integer>oddNums=new HashSet<>();
            HashSet<Integer>evennums=new HashSet<>();
            for(int j=i;j<n;j++){

                if(nums[j]%2==0)
                    evennums.add(nums[j]);
                else
                    oddNums.add(nums[j]);

                if(evennums.size()==oddNums.size())
                {
                    maxans=Math.max(j-i+1,maxans);
                }

            }
        }
        return maxans;
    }
    public static  int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])%2==0)
                sum+=nums[i];
        }
        return sum;
    }
    public static  int rangeSum(int[] nums, int n, int left, int right) {
        int newar[]=new int[n*(n+1)/2];
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                newar[k++]=sum;
            }
        }
        Arrays.sort(newar);
        int ans=0;
        for(int i=left-1;i<right;i++)
        {
            ans+=newar[i];
        }
        return ans;
    }




    public static int maxFrequencyElements(int[] nums) {
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            max=Math.max(max,map.get(n));
        }

        int finalMax = max;
        int ans =map.values().stream().filter(e->e==finalMax).mapToInt(Integer::intValue).sum();
        System.out.println(ans);
return 0;
    }
    public static long maxTotalValue(int[] nums, int k) {
            int maxval= Arrays.stream(nums).max().getAsInt();
            int minval= Arrays.stream(nums).min().getAsInt();
            long ans = (long)maxval - (long)minval;
            return k * ans;
    }
    public static int[] maxKDistinct(int[] nums, int k) {
        List<Integer>newal=new ArrayList<>();
        for(int value:nums){
            if(!newal.contains(value))
            {
                newal.add(value);
            }
        }
        Collections.sort(newal,Collections.reverseOrder());
        int ar[]=new int[Math.min(k,newal.size())];
         for(int i=0;i<Math.min(k,newal.size());i++){
             ar[i]=newal.get(i);
         }
        System.out.println(Arrays.toString(ar));
         return ar;
    }
    public static int earliestTime(int[][] tasks) {
        int min=Integer.MAX_VALUE;int sum=0;
        for (int i=0;i<tasks.length;i++){
            int mintask=tasks[i][0];
            for(int j=1;j<tasks[i].length;j++){
                sum=mintask+tasks[i][j];
            }
            min=Math.min(min,sum);
        }
        return min;

    }

    public static boolean partitionArray(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int count:map.values()){
            if(count>nums.length/k){
                return  false;
            }
        }
    return  nums.length%k==0;
    }
    public static int gcdOfOddEvenSums(int n) {
        int odd=0;
        int even=0;
        int countodd=0;
        int counteven=0;
        for(int i=1;i<=1000;i++){
            if(counteven==n&&countodd==n)
            {
                break;
            }
            if(i%2==0){
                even=even+i;
                counteven++;
            }
            else {
                odd += i;
                countodd++;
            }
        }
        return findgcd(odd,even);
    }
    public static int  findgcd(int a ,int b){
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }

    public static int minOperations(int[] nums) {
        int equal = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0]) { equal = 0;
                return equal; }
        }
        if (equal==0) return 1;
        return 0;
    }
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> h=new HashSet<Integer>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<friends.length;i++){
            h.add(friends[i]);
        }
        for(int i=0;i<order.length;i++){
            if(h.contains(order[i])){
                al.add(order[i]);
            }
        }
        int []finshedorder=al.stream().mapToInt(i -> i).toArray();

        return finshedorder;

    }

    private static void SingleNumber(int[] ar, int n) {
//        HashMap<Integer,Integer> map= new HashMap<>();
//        for(int i=0;i<n;i++){
//            if(map.containsKey(ar[i])){
//                map.replace(ar[i],map.get(ar[i])+1);
//            }
//            else{
//                map.put(ar[i],1);
//            }
//        }
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//            if(entry.getValue()==1){
//                System.out.println(entry.getKey());
//            }
//        }

        //Using XOR
//        a (xor) 0 =0
//        a (xor) a= 0 // a xor+ a =0  so it remove all the dul;poicate s
//        a^a^ b^a^b^c=c it will remove all the deuplicates and retrune the uniquee value

          int xor=0;
        for(int i=0;i<n;i++){
            xor^=ar[i];
        }
        System.out.println(xor);

//        System.out.println(map.containsValue(1));

    }

    private static  void MissingNumber(int [] ar,int n){
        int rangesum=0;
        int arrraysum=0;
        for(int i=0;i<=n;i++){
            rangesum+=i;
        }
        for(int i=0;i<n;i++){
            arrraysum+=ar[i];
        }
        System.out.println(rangesum-arrraysum);
    }

    private static void MaxConsecutiveOne(int[] ar) {
        int maxcount=0;
        int currentcount=0;
        int i=0;
        while(i<ar.length){
            if(ar[i]==1)
            {
                currentcount++;
            }
            else {
                maxcount=Math.max(currentcount,maxcount);
                currentcount=0;

            }
            i++;
        }
        System.out.println(Math.max(currentcount,maxcount));
    }

    private static void MovingZeroToEnd(int ar[]){
        int i=0; int index=0;
        while(i<ar.length){
                if(ar[i]!=0){
                    int temp=ar[i];
                    ar[i]=ar[index];
                    ar[index]=temp;
                    index++;
            }
                i++;
        }
       System.out.println(Arrays.toString(ar));

   }


    private static void MergeSorrtedArray(Scanner sc) {
        int n= sc.nextInt();
        int nums1[]=new int[n];
        for(int i=0;i<n;i++){
            nums1[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        int  nums2[]=new int[m];
        for(int i=0;i<m;i++){
            nums2[i]=sc.nextInt();
        }
        int mergeSortedArray[]=new int[n+m];
        int i=0;int j=0; int k=0;
        while(i<n&&j<m){
            if(nums1[i]<=nums2[j]){
                mergeSortedArray[k]=nums1[i];
                i++;
                k++;
            }
            else if(nums2[j]<=nums1[i]){
                mergeSortedArray[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            mergeSortedArray[k]=nums1[i];
            i++;
            k++;
        }
        while (j<m){
            mergeSortedArray[k]=nums2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(mergeSortedArray));
    }

    private static void BestTimeToBuySellStock(int n, int[] ar) {
        int maxprofit=0;
        int minStockprice=ar[0];
        int i=1;
        while(i<n){
            if(ar[i]-minStockprice>maxprofit){
                maxprofit=(ar[i]-minStockprice);
            }
            if(ar[i]<minStockprice){
                minStockprice=ar[i];
            }
            i++;
        }
        System.out.println(maxprofit);
    }

    private  static void ReverseString(Scanner sc){
       int n = sc.nextInt();
       char ar[]=new char[n];
       for(int i=0;i<n;i++){
           ar[i]=sc.next().charAt(0);
       }
       int i=0;
       int j=ar.length-1;
       while(i<j){
           char temp=ar[i];
           ar[i]=ar[j];
           ar[j]=temp;
           i++;
           j--;
       }
       System.out.println(Arrays.toString(ar));
   }
   private static void RemoveElement(int ar[],Scanner sc){
       int val =sc.nextInt();
        int x=0;
        for(int i=0;i<ar.length;i++) {
          if(ar[i]!=val){
              ar[x]=ar[i];
              x=x+1;
          }
        }
       System.out.println(x);
       System.out.println(Arrays.toString(ar));
   }

    private static void RemoveDuplicates(int ar[]){
        int x=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]>ar[x]){
                x=x+1;
                ar[x]=ar[i];
            }
        }
        System.out.println(x+1);
    }


//	private static void Check(int n) {
//		// TODO Auto-generated method stub
//		ArrayList<String>al =new ArrayList<String>();
//		Scanner sc=new Scanner (System.in);
//		for(int i=0;i<n;i++) {
//			String a =sc.nextLine();
//			al.add(a);
//		}
//		for(int i=0;i<al.size();i++) {
//			System.out.print("'"+al.get(i)+"'" + ",");
//		}
//	}




    private static void RotatearraybyDplace(int[] ar) {
        int n=ar.length;
        Scanner sc=new Scanner (System.in);
        int k=sc.nextInt();
        reversearray(ar,0,k-1);
        reversearray(ar,k,n-1);
        reversearray(ar, 0, n-1);
        System.out.println(Arrays.toString(ar));
    }




    private static void reversearray(int[] ar, int start, int end) {

        while(start<=end) {
            int temp=ar[start];
            ar[start]=ar[end];
            ar[end]=temp;
            start++;
            end--;
        }
    }




    private static void Rotatearrayone(int[] ar) {
//			Sample input 1:
//			4
//			5 7 3 2
//			Sample output 1:
//			7 3 2 5

        int n=ar.length;
        int temp=ar[0];
        for(int i=1;i<n;i++) {
            ar[i-1]=ar[i];

        }
        ar[n-1]=temp;
        System.out.println(Arrays.toString(ar));
    }




    private static void FindUnique(int[] ar) {
//		   ArrayList<Integer> al = new ArrayList<Integer>();
//		   al.add(ar[0]);
//		for(int i=1;i<ar.length;i++) {
//				if(!al.contains(ar[i]))
//				{
//					al.add(ar[i]);
//				}
//
//	}
//		System.out.println(al.toString());
//
        //Optimal Approach
        int i=0;
        for(int j=1;j<ar.length;j++) {
            if(ar[i]!=ar[j]) {
                i++;
                ar[i]=ar[j];

            }
        }
        System.out.println(i+1);
    }

    private static void GivenArraySorted(int[] ar) {
        int n=ar.length;
        boolean check=false;
        for(int i=0;i<ar.length-1;i++) {
            if(ar[i]>ar[i+1])
            {
                check=true;
                break;
            }
        }
        if(check==true) {
            System.out.println("No is not in dcereaing order");
        }
        else {
            System.out.println("Is in dcereaing order");
        }

    }

    private static void LargestElementArray(int ar[]) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++) {
            if(max<ar[i])
            {
                max=ar[i];
            }

        }
        System.out.print(max);
    }
    public static void ScondLargestandSecondSmallest(int ar[]) {


        int SecondMax=SecondLargest(ar, ar.length);
        int SecondMin=SecondSmallest(ar,ar.length);

        System.out.print(SecondMax +" "+ SecondMin);

    }

    public static int SecondLargest(int ar[],int n)
    {
        if (n<2)
            return -1;

        int max=ar[0];
        int SecondMax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(ar[i]>max) {
                SecondMax=max;
                max=ar[i];
            }
            else if (ar[i]>SecondMax&& ar[i]!=max) {
                SecondMax=ar[i];
            }
        }
        return 	SecondMax;
    }

    public static int SecondSmallest(int ar[],int n)
    {
        if (n<2)
            return -1;

        int min=ar[0];
        int SecondMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(ar[i]<min) {
                SecondMin=min;
                min=ar[i];
            }
            else if (ar[i]<SecondMin&& ar[i]!=min) {
                SecondMin=ar[i];
            }
        }
        return 	SecondMin;
    }





}
