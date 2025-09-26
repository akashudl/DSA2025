package org.example.Bitwise;

public class BitwiseAll {
    public static void main(String[] args) {

        int n=3;
         // Check if number is even or not n&1==0
//        if((n&1)==0) {
//            System.out.println("Even no");
//        }
//            else
//            System.out.println("odd no");
            // Swap two numbers

//        int a=2;
//        int b=4;
//        a=a^b;
//        b=a^b;
//        a=a^b;
//        System.out.println(a);
//        System.out.println(b);

//        int a=0b1101;
//        int b=0b1101;
//        System.out.println(a+b);


//
//        3. Common Tricks in DSA
//        Task	Formula	Example
//        Check even/odd	(n & 1) == 0	4 is even, (4 & 1) == 0
//        Multiply by 2^k	n << k	5 << 1 = 10  n × (2^k)

//        Divide by 2^k	n >> k	8 >> 2 = 2
//        Set i-th bit	`n	(1 << i)`
//        Clear i-th bit	n & ~(1 << i)	Clear bit 0 in 5 → 4
//        Toggle i-th bit	n ^ (1 << i)	Toggle bit 1 in 5 → 7
//        Check i-th bit	(n & (1 << i)) != 0	Check bit 2 in 5 → true
//        Turn off last set bit	n & (n - 1)	12 (1100) → 8 (1000)
//        Get last set bit	n & (-n)	12 → 4
//        Check power of 2	(n & (n - 1)) == 0	8 → true
//
//💪 20+ PRACTICE PROBLEMS
//                Easy
//        Check if a number is even using bitwise.
           if ((n&1)==0){
               System.out.println("Even");
           }
           else{
               System.out.println("not even");
           }

//
//        Swap two numbers without temp using XOR.
                int a=2;
                int b=4;
                a=a^b;
                b=a^b;
                a=a^b;
                System.out.println(a);
                System.out.println(b);
//
//           Count set bits in an integer.
   n=5;
//        int count = 0;                // Step 1: start with 0 set bits counted
//        while (n > 0) {               // Step 2: repeat until number becomes 0
//            n = n & (n - 1);          // Step 3: remove the rightmost 1-bit
//            count++;                  // Step 4: increment count (we removed 1 set bit)
//        }
//        System.out.println(count);


//        Find the i-th bit of a number.
//        int i=2;
//           int mask= 1<<i;
//           int bit = (n&mask)!=0?1:0;
//        System.out.println(bit);
//
//        Set the i-th bit of a number.
//        n=n|(1<<i);
//        System.out.println(n=n|(1<<i));
//
//        Clear the i-th bit of a number.
//
//        Toggle the i-th bit of a number.
//
//        Multiply a number by 8 using bitwise.
//
//        Medium
//        Check if a number is a power of 2.
//        (n & (n - 1)) == 0	8

        int x=9;
        if((x&(x-1))==0){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
//
//        Find the position of the only set bit in a number.
//
//        Reverse bits of a number.
//
//        Turn off the rightmost set bit.
//
//        Get the rightmost set bit.
//
//        Given an array where every element appears twice except one, find that single number.
          int ar[]={1,1,1,2,2,2,3,3,3,6};
          int Uniqueelement=0;
          for(int i=0;i<ar.length;i++){
            Uniqueelement=Uniqueelement^ar[i];
          }
        System.out.println(Uniqueelement);
//
//         Given an array where every element appears thrice except one, find that single number.
//
//        Hard
//        Find two non-repeating elements in an array where others repeat twice.
//
//        Find the missing number from 1 to n using XOR.
         int ar1[]={1,2,4,5,3};
         int xor1=0;
         int xor2=0;
        for (int i = 1; i <= ar1.length; i++) {
            xor1 ^= i;
        }

        for(int i=0;i<ar1.length;i++){
             xor2^=ar[i];
         }
         int missingno=xor1^xor2;
        System.out.println("missing no is: "+missingno);

//
//        Count total set bits from 1 to n.
//
//        Find the XOR of all numbers from L to R.
//          int x=3;
//        The XOR of numbers from 0 to n follows a repeating pattern every 4 numbers:
//
//        n % 4	          XOR from 0 to n
//        0	                  n
//        1	                  1
//        2	                n + 1
//        3	                  0
          int L=3 ;int R=9;
        System.out.println(xorFromLtoR(L,R));

//
//        Find the maximum subset XOR in an array.
//
//        Implement a fast exponentiation using bitwise.


    }

    private static int  xorFromLtoR(int L, int R) {
        return xorFrom0toN(R)^xorFrom0toN(L);
    }
    private static int xorFrom0toN(int n){
        int mod=n%4;
        if(mod==0) return n;
        else if(mod==1) return 1;
        else if(mod==2) return n+1;
        else return 0;
    }
}
