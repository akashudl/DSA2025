package org.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        sc.nextLine();
        int ar[]=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
//        String s[]=new String[n];
//        for(int i=0;i<n;i++){
//            s[i]=sc.nextLine();
//        }
//        NearestGreaterElementToRight(ar,n);
//        NearestGreaterElementToLeft(ar,n);
//          NearestSmalllestElementToLeft(ar,n);
//            NearestSmallestElementToRight(ar,n);
//        calPoints(s);
//        int nums1[]={4,1,2};
//        int nums2[]={1,3,4,2};
//        nextGreaterElement(nums1,nums2);
//        StcokSpanProblem(ar);

//        System.out.println(maxHistogram(ar));
//        String s=sc.nextLine();
//        System.out.println(isValid(s));
//        dailyTemperatures(ar);
        removeSubstring("(())",1);
    }


    public static String removeSubstring(String s, int k) {
        String pattern="(".repeat(k) + ")".repeat(k);
        Stack<Character> stack=new Stack<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            stack.push(ch[i]);
            while(stack.size()>=2*k&& BalancedStack(stack,k)){
                for (int j = 0; j < 2 * k; j++) stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) sb.append(c);
        System.out.println(sb);
        return sb.toString();
    }

    private static boolean BalancedStack(Stack<Character> stack, int k) {
        int left=stack.size()-2*k;
        for(int i=left;i<left+k;i++){
            if(stack.get(i)!='(')
                return false;

        }
        for (int i = left + k; i < left + 2 * k; i++) {
            if (stack.get(i) != ')') return false;
        }
        return true;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(String c:tokens){
            if(c.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(c.equals("-")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b-a);
            }
            else if(c.equals("*")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b*a);
            }
            else if(c.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }
            else {
                stack.push(Integer.valueOf(c));
            }

        }
        return stack.pop();

    }

    public static void dailyTemperatures(int[] temperatures) {

        int ans[]=new int[temperatures.length];
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                ans[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

//        ArrayList<Integer>al=new ArrayList<>();
//        boolean flag=false;
//        for(int i=0;i<temperatures.length;i++){
//            int count=0;
//            for(int j=i+1;j<temperatures.length;j++){
//
//                if(temperatures[j]>temperatures[i]){
//                    al.add(++count);
//                    flag=true;
//                    break;
//                }
//                count++;
//                flag=false;
//            }
//            if(flag==false)
//                al.add(0);
//        }
//        int ar[]=new int[temperatures.length];int i=0;
//        for(int num:al){
//            ar[i++]=num;
//        }
//        System.out.println(Arrays.toString(ar));
    }
    public static boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(')');
            else if (s.charAt(i)=='{')
                stack.push('}');
            else if(s.charAt(i)=='[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();





//        if(s.length()==1)
//            return true;
//        else if(s.length()==0)
//            return false;
//        HashMap<Character,Character>map=new HashMap<>();
//        map.put('}','{');
//        map.put(')','(');
//        map.put(']','[');
//        boolean flag=false;
//        Stack<Character>stack=new Stack<>();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
//                stack.push(s.charAt(i));
//                continue;
//            }
//            if(stack.size()==0 ||map.get(s.charAt(i))!=stack.pop()){
//                return  false;
//            }
//        }
//        if(stack.size()==0)
//        return true;
//
//        return  false;
    }
    private static int maxHistogram(int[] ar) {
        int [] prevS= prevsmaller(ar);
        int [] nextS =nextSmaller(ar);
        int maxarea=0;
        for(int i=0;i<ar.length;i++){
            int width=nextS[i]-prevS[i]-1;
            int area=ar[i]*width;
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }

    private static int[] prevsmaller(int[] ar) {
        Stack<Integer>s=new Stack<>();
        int newar[]=new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            newar[i] = -1;
        }
        for(int i=0;i<ar.length;i++){

            while(!s.isEmpty() &&ar[i]<ar[s.peek()])
            {
                s.pop();
            }
            if(!s.isEmpty()){
                newar[i]=s.peek();
            }
            s.push(i);
        }
        return newar;
    }

    private static int[] nextSmaller(int[] ar) {
        Stack<Integer>s=new Stack<>();
        int newar[]=new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            newar[i] = ar.length;
        }
        for(int i=0;i<ar.length;i++){

            while(!s.isEmpty() &&ar[i]<ar[s.peek()])
            {
                newar[s.pop()] = i;
            }
            s.push(i);
        }
        return newar;
    }

    public static int[] StcokSpanProblem(int ar[]){
        Stack<Integer>stack =new Stack<>();
        int ans[]=new int[ar.length];
        for(int i=0;i<ar.length;i++){
           while(!stack.isEmpty()&& ar[stack.peek()]<=ar[i]){
               stack.pop();
           }
            ans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return  ans;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] ans = new int[nums1.length];
        Stack<Integer>s=new Stack<>();
        for(int num:nums2){
            while (!s.isEmpty() && num>s.peek()){
                map.put(s.pop(),num);
            }
            s.add(num);
        }
        int i=0;
        for(int num:nums1){
            ans[i++]=map.getOrDefault(num,-1);
        }
        return ans;
//        BruteFroce
        //        int flag=1;
//        HashMap<Integer,Integer>map=new HashMap<>();
//        for(int i=0;i<nums2.length;i++){
//            map.put(nums2[i],i);
//        }
//        ArrayList<Integer> al =new ArrayList<Integer>();
//        for(int i=0;i<nums1.length;i++){
//            int index_position=map.get(nums1[i]);
//            for(int j=index_position;j<nums2.length;j++){
//                if(nums2[j]>nums1[i]){
//                    al.add(nums2[j]);
//                    flag=1;
//                    break;
//                }
//                else {
//                    flag=2;
//                }
//            }
//            if(flag==2){
//                al.add(-1);
//            }
//        }
//
//        int size = al.size();
//        int[] arr = new int[al.size()];
//        for (int i = 0; i < size; i++) {
//            arr[i] = al.get(i);
//        }
//        return arr;
    }
    private static void NearestSmallestElementToRight(int[] ar, int n) {
        Stack<Integer>stack =new Stack<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=ar.length-1;i>=0;i--){
            if(stack.size()==0){
                al.add(-1);
            }
            else if(stack.size()>0 && stack.peek()<ar[i]){
                al.add(stack.peek());
            }
            else if (stack.peek()>=ar[i]){
                while (stack.size()>0&& stack.peek()>=ar[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    al.add(-1);
                }
                else{
                    al.add(stack.peek());
                }
            }
            stack.push(ar[i]);

        }
        System.out.println(al);
    }
    private static void NearestSmalllestElementToLeft(int[] ar, int n) {
        Stack<Integer>stack =new Stack<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(stack.size()==0){
                al.add(-1);
            }
            else if(stack.size()>0&& stack.peek()<ar[i]){
                al.add(stack.peek());
            }
            else if(stack.peek()>=ar[i]){
                while (stack.size()>0&&stack.peek()>=ar[i]){
                    stack.pop();
                }
                if(stack.size()==0)
                    al.add(-1);
                else
                    al.add(stack.peek());
            }
            stack.push(ar[i]);

        }
        System.out.println(al);
    }

    public static int calPoints(String[] operations) {
        Stack<Integer>stack = new Stack();
        for(String ops:operations){
            if(ops.equals("+")){
                int top=stack.pop();
                int newTop=top+stack.peek();
                stack.push(top);
                stack.push(newTop);
            }
            else if(ops.equals("C")){
                stack.pop();
            }
            else if(ops.equals("D")){
                stack.push(2*stack.peek());
            }
            else {
                stack.push(Integer.valueOf(ops));
            }
        }
        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    public static boolean isInteger (String s){
        try {
            Integer.parseInt(s);
            return true;   // valid integer
        } catch (NumberFormatException e) {
            return false;  // not an integer
        }
    }
    private static void NearestGreaterElementToLeft(int[] ar, int n) {
        Stack<Integer>stack =new Stack<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(stack.size()==0){
                al.add(-1);
            }
            else if(stack.size()>0 && stack.peek()>ar[i]){
                al.add(stack.peek());
            }
            else if (stack.peek()<=ar[i]){
                while (stack.size()>0&& stack.peek()<=ar[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    al.add(-1);
                }
                else{
                    al.add(stack.peek());
                }
            }
            stack.push(ar[i]);

        }
        System.out.println(al);
    }

    private static void NearestGreaterElementToRight(int[] ar, int n) {
        Stack<Integer>stack =new Stack<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=ar.length-1;i>=0;i--){
            if(stack.size()==0){
                al.add(-1);
            }
            else if(stack.size()>0 && stack.peek()>ar[i]){
                al.add(stack.peek());
            }
            else if (stack.peek()<=ar[i]){
            while (stack.size()>0&& stack.peek()<=ar[i]){
                stack.pop();
            }
            if(stack.size()==0){
                al.add(-1);
            }
            else{
                al.add(stack.peek());
            }
            }
            stack.push(ar[i]);

        }
        int size = al.size();
        int[] arr = new int[al.size()];
        for (int i = 0; i < size; i++) {
            arr[i] = al.get(size - 1 - i);
        }
        System.out.println(al);
    }
}
