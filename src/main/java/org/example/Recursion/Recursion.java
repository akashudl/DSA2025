package org.example.Recursion;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Recursion {
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int k=sc.nextInt();
//        Stack  <Integer> stack=new Stack<>();
//        int ar[]=new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            stack.push(sc.nextInt());
//        }
//        System.out.println(stack.size());
//        int k=(stack.size()+1)/2;
        //System.out.println( SumOfNaturalNumber(n));
//        System.out.println(SumOfAllNumberInArray(ar,n-1));
      //  System.out.println(Factorial(n));
//        boolean a =(n & (n - 1)) == 0?true:false;
//        System.out.println(a);
       // System.out.println(powerof2(n));
//        solvestackmiddle(stack,k);
//        System.out.println(stack);
       //  revrsestack(stack);
//        System.out.println(KthGrammer(n,k));
//        TowerOfHanoi(n,"S","D","H"); //S-> Source D-> Destintion, H-> helper

//        SUbset ,Input<output problem>
        //System.out.println(stack);
        String s=sc.nextLine();
//        String op= ""+String.valueOf(s.charAt(0));
//        s=s.substring(1);
//        printPermutation(s,op);
        String output="";
//        printPermutaioncapital(s,output);
//        printsubset(s,op);
          Vector<String> vector=new Vector<>();
          LetterCasePermutation(s,output,vector);
          for(String a:vector){
              System.out.println(a+" ");
          }

    }

    private static Vector<String> LetterCasePermutation(String input, String output, Vector<String> vector) {
        if(input.length()==0)
        {
            vector.add(output);
            return vector;
        }
        if(Character.isLetter(input.charAt(0))){
            String op1=output;
            String op2=output;
            op1=op1+Character.toUpperCase(input.charAt(0));
            op2=op2+Character.toLowerCase(input.charAt(0));
            input=input.substring(1);
            LetterCasePermutation(input,op1,vector);
            LetterCasePermutation(input,op2,vector);
        }
        else{
            String op1=output;
            op1+=input.charAt(0);
            input=input.substring(1);
            LetterCasePermutation(input,op1,vector);
        }
        return vector;
    }

    private static void printPermutaioncapital(String input, String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        char normalchar=input.charAt(0);
        char Uppercase=Character.toUpperCase(normalchar);
        input=input.substring(1);
        printPermutaioncapital(input,output+normalchar);
        printPermutaioncapital(input,output+Uppercase);
    }

    private static void printPermutation(String input, String output) {
        if(input.length()==0)
        {
            System.out.println(output);
            return;
        }
        String op1=output+"_"+input.charAt(0);
        String op2=output+input.charAt(0);
        input=input.substring(1);
        printPermutation(input,op1);
        printPermutation(input,op2);
        return;
    }

    private static void printsubset(String s, String op) {
        if(s.length()==0){
            System.out.println(op);
            return;
        }
        String op1=op;
        String op2=op;
        op2+=s.charAt(0);
        s=s.substring(1);
        printsubset(s,op1);
        printsubset(s,op2);
    }

    private static void TowerOfHanoi(int n, String S, String D, String H) {
        if(n==1){
            System.out.println("moving plate"+n+" from" +S + "to "+D );
            return;
        }
        TowerOfHanoi(n-1,S,H,D);
        System.out.println("moving plate "+n+ "from" +S + "to "+D );
        TowerOfHanoi(n-1,H,D,S);
        return;

    }

    private static int KthGrammer(int n, int k) {
        if(n == 1 && k == 1) return 0;

        int mid = (int)Math.pow(2, n - 1) / 2;

        if(k <= mid){
            return KthGrammer(n - 1, k);
        }
        else{
            return KthGrammer(n - 1, k - mid)^1;
        }
    }

    private static void revrsestack(Stack<Integer> stack) {
        if(stack.size()==1)
            return;

        int temp=stack.pop();
        revrsestack(stack);
        insertinstack(stack,temp);
        return;
    }

    private static void insertinstack(Stack<Integer> stack, int temp) {
        if(stack.size()==0) {
            stack.push(temp);
            return;
        }
        int val=stack.peek();
        stack.pop();
        insertinstack(stack,temp);
        stack.push(val);
        return;

    }

    private static void solvestackmiddle(Stack<Integer> stack, int k) {
        if(k==1){
            stack.pop();
            return;
        }
        int temp= stack.peek();
        stack.pop();
       solvestackmiddle(stack,k-1);
        stack.push(temp);
        return;

    }

    private static boolean powerof2(int n) {
        if(n==1)
            return true;
        else if(n<1 || (n%2!=0))
            return false;
            return powerof2(n/2);
    }

    private static int  Factorial(int n) {
        if(n==0)
            return 1;
         return  n*Factorial(n-1);
    }


    private static int SumOfAllNumberInArray(int[] ar,int n) {
        if(n==0)
            return ar[n];
        return  ar[n]+SumOfAllNumberInArray(ar,n-1);
    }

    private static int SumOfNaturalNumber( int n) {
        if(n==1)
            return 1;
        return n+SumOfNaturalNumber(n-1);
    }

}
