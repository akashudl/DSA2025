package org.example.StringsPractice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        System.out.println(lengthOfLastWordApproach2(s));
//        String arr[]={"leet","code"};
//        System.out.println(findWordsContaining(arr,'e'));
//        System.out.println(numJewelsInStones(sc));
//        System.out.println(maxFreqSum(s));

      //  reverseStr(s,3);
      //  balancedStringSplit(s);
//        System.out.println(isPalindrome(s));
//        System.out.println(isAnagram("anagram","nagaram"));
//        System.out.println(isIsomorphic("foo","bar"));
//        System.out.println(minOperations(s));
//        System.out.println( majorityFrequencyGroup(s));
        System.out.println(maximumNumberOfStringPairs(     new String[] {"ku","dd","gu","uk"}));
    }


    public static boolean scoreBalance(String s) {
        int totalsum=0;
        for(int i=-0;i<s.length();i++){
            totalsum += (s.charAt(i) - 'a' + 1);
        }
        int prefixsum=0;
        for(int i=0;i<=s.length()-2;i++){
            prefixsum+=(s.charAt(i)-'a'+1);
            if (prefixsum*2== totalsum) return true;
        }
        return false;
    }
    public static int maximumNumberOfStringPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            StringBuffer sbf = new StringBuffer(words[i]);
            String s= String.valueOf(sbf.reverse());
           for(int j=i+1;j<words.length;j++){
               if(s.equals(words[j]))
                   count++;
           }

        }
        return count;


    }

    public static String majorityFrequencyGroup(String s) {
        Map<Character,Integer>m=new HashMap<>();
        for(Character c:s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        Map<Integer, List<Character>> groupm = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            int freq = entry.getValue();
            groupm.computeIfAbsent(freq, k -> new ArrayList<>()).add(entry.getKey());
        }

        List<Character> bg = groupm.entrySet().stream()
                .max(Comparator.<Map.Entry<Integer, List<Character>>>comparingInt(e -> e.getValue().size())
                        .thenComparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        StringBuilder res = new StringBuilder();
        for (char c : bg) {
            res.append(c);
        }

        return res.toString();

    }
    public static int minOperations(String s) {
        int maxcount =0;
        String newstring=s;
        for(int i=0;i<s.length();i++){
            char  c=newstring.charAt(i);
            int steps=(26-(c-'a'))%26;
            maxcount=Math.max(steps,maxcount);
        }
        System.out.println(maxcount);
        return  maxcount;
    }
    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);


            if (!mp.containsKey(s)) {
                mp.put(s, res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(s)).add(arr[i]);

        }
        return res;
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set2 = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)
                    return false;
            }else{
                if(set2.contains(c2))
                    return false;

                map.put(c1,c2);
                set2.add(c2);
            }
        }
        return true;
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int count=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        count=map.size();
        for(int j=0;j<t.length();j++){
            if(map.containsKey(t.charAt(j))){
                map.put(t.charAt(j),map.get(t.charAt(j))-1);
                if(map.get(t.charAt(j))==0)
                {
                    map.remove(t.charAt(j));
                    count++;
                }
            }
        }
        if(count==0||map.size()==0)
            return true;
        else
            return  false;
    }
    public static String longestCommonPrefix(String[] strs) {
        int x=0;
        while (x<strs[0].length()){
            char ch=strs[0].charAt(x);
            for(int i=0;i<strs.length;i++){
                if(x>=strs[i].length()||ch!=strs[i].charAt(x)){
                    return strs[0].substring(0,x);
                }

            }
            x++;
        }
        return strs[0];
    }

    private static void reverseStr(String s,int k) {

        char [] chararray=s.toCharArray();
        for(int i=0;i<chararray.length;i=i+(2*k)){
            int n = Math.min(k, chararray.length - i);  // handle leftover characters
            int mid = n / 2; // floor already happens in int division
            for(int j=0;j<=mid;j++){
                char temp=chararray[i+j];
                chararray[i+j]=chararray[i+n-1-j];
                chararray[i+n-1-j]=temp;
            }
        }
        System.out.println(chararray);

    }

    public static  boolean isPalindrome(String s) {
        if(s.length()==1)
            return true;
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;int j=cleaned.length()-1;
        while(i<j){
            if(cleaned.charAt(i)!=cleaned.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }


    public static  int balancedStringSplit(String s) {
        int balance=0;
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='L')
                balance=balance-1;
            else{
                balance=balance+1;
            }
            if(balance==0)
            {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int lengthOfLastWordApproach1(String s) {
        String w[] = s.split(" ");
        String lastword = "";
        for (int i = 0; i < w.length; i++) {
            if (w[i] != " ") {
                lastword = w[i];
            }
        }
        return lastword.length();
    }

    public static int lengthOfLastWordApproach2(String s) {
        int n = s.length() - 1;
        int count = 0;
        while (n >= 0) {
            if (s.charAt(n) != ' ') {
                ++count;
            } else if (count > 0)
                break;
            --n;
        }
        return count;
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
//            if(words[i].indexOf(x)>=0){
//                al.add(i);
//            }
            String check = words[i];
            for (int j = 0; j < check.length(); j++) {
                if (check.charAt(j) == x) {
                    al.add(i);
                    break;
                }
            }

        }

        return al;
    }

    public static int numJewelsInStones(Scanner sc) {
        String jewels = sc.nextLine();
        String stones = sc.nextLine();
        int count = 0;
        HashSet<Character> a = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            a.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (a.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;

    }

    public static int maxFreqSum(String s) {
//        HashMap<Character,Integer>vowels=new HashMap<>();
//        HashMap<Character,Integer>constant=new HashMap<>();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
//                if(vowels.containsKey(s.charAt(i))){
//                    vowels.put(s.charAt(i), vowels.get(s.charAt(i))+1);
//                }
//                else{
//                    vowels.put(s.charAt(i),1);
//                }
//            }
//            else {
//                if (constant.containsKey(s.charAt(i))) {
//                    constant.put(s.charAt(i), constant.get(s.charAt(i)) + 1);
//                } else {
//                    constant.put(s.charAt(i), 1);
//                }
//
//            }
//    }
//        int maxvowelfrequecny=vowels.values().stream().max((a,b)->a-b).orElse(0);
//        int maxconstantfrequency=constant.values().stream().max(Integer::compare).orElse(0);
//
//        return maxvowelfrequecny+maxconstantfrequency;

//        Optimize Solution
        HashMap<Character, Integer> map = new HashMap<>();
        int maxVowel = 0;
        int maxConstant = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                maxVowel = Math.max(maxVowel, map.get(c));

            } else {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                maxConstant = Math.max(maxConstant, map.get(c));
            }
        }
        return maxConstant+maxVowel;
    }

    private static boolean isVowel ( char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}