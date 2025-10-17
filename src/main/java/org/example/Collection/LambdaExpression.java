package org.example.Collection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpression {
    public static void main(String[] args) {
//        Print a list using Lambda Expressions
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        names.stream().forEach(name-> System.out.print(name+" \n"));
//        . Filter even numbers from a list using Streams
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.stream().filter(num->num%2==0).forEach(n-> System.out.println(" "+n));

//        3. Find the maximum value in a list using Streams.
//                List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40);
//                int max=numbers2.stream().max((Integer val1,Integer val2)->val1-val2).orElse(0);
//        System.out.println(max);

//        4. Convert a list of strings to uppercase.
                List<String> names2 = Arrays.asList("alice", "bob");
//        map() = transform each element into something else (returns a new stream).
        Stream<String> s=names2.stream().map(n->n.toUpperCase());
        System.out.println(s.collect(Collectors.toList()));


//        5. Group strings by their length using groupingBy().
//        Collectors.groupingBy(classifier, downstreamCollector)
//        Classifier → decides the grouping key.
//
//        Downstream → decides what to do with grouped values.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie","Akash");
        Map<Integer, List<String>> grouped=names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);

//        6. Find the sum of numbers using reduce().
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum=numbers.stream().reduce((Integer val1,Integer val2)->val1+val2 ).get();
        System.out.println(sum);

//        . Count word occurrences in a list using groupingBy()
        List<String> words = Arrays.asList("apple", "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(m->m,Collectors.counting())));




//        11. Use Stream.distinct() to remove duplicates from a list.
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(numbers3.stream().distinct().collect(Collectors.toList()));
//        12. Find all elements starting with "A" in a list.
                List<String> names3= Arrays.asList("Alice", "Bob", "Annie", "Alex");
        System.out.println(names3.stream().filter(name->name.startsWith("A")).collect(Collectors.toList()));

//        Sort a list of strings alphabetically and in reverse order.
        List<String> names4 = Arrays.asList("Charlie", "Alice", "Bob");
        List<String>sortednames=names4.stream().sorted().collect(Collectors.toList());
        System.out.println(names4.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList()));
        System.out.println(sortednames);

//
//        14. Flatten a list of lists using flatMap().
                List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        System.out.println(nestedList.stream().flatMap(List::stream).collect(Collectors.toList()));

//        15. Use Collectors.partitioningBy() to separate even and odd numbers.
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean,List<Integer>>m=numbers5.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(m);

//        Find the second highest number in a list
        List<Integer> numbers6 = Arrays.asList(10, 20, 30, 40, 50);
        int secondHighest=numbers6.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(secondHighest);

//        . Count the frequency of characters in a string using Streams.
        String s1="JAVA";
        Map<Character,Long>map=s1.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

//        18. Generate an infinite Stream of even numbers and limit it to 10 elements.
        List<Integer> evenNumbers =Stream.iterate(0,n->n+2).limit(10).collect(Collectors.toList());
        System.out.println(evenNumbers);

//        Check if all elements in a list are greater than a given number
        System.out.println(numbers6.stream().filter((a)-> a>20).collect(Collectors.toList()));


//        Count occurrences of each word in a sentence
        String sentence = "Java is fun and Java is powerful";
        Map<String,Long>map1= Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(sp->sp,Collectors.counting()));
        System.out.println(map1);

//        24. Find the longest word in a list.
                List<String> words3 = Arrays.asList("apple", "banana", "cherry", "date");
                String word= words3.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(word);

//        27. Find the minimum value in a list using Streams.
                List<Integer> numbers4 = Arrays.asList(10, 20, 5, 15,-1);
        System.out.println(numbers4.stream().min(Integer::compare).orElse(0));

//        Find duplicate elements in a list using Streams
        List<Integer> numbers8 = Arrays.asList(1, 1, 3, 2,4,4,5,1,2);
        System.out.println(numbers8.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet().stream().filter((entry)->entry.getValue()>1).map(Map.Entry::getKey).toList());

//        35. Find all palindromic strings in a list.
        List<String> words8 = Arrays.asList("madam", "racecar", "java", "level",
                "hello");
        System.out.println(words8.stream().filter((word1)->word1.equals(new StringBuilder(word1).reverse().toString())).collect(Collectors.toList()));

//        34. Use Collectors.teeing() to compute two operations on a Stream.
                List<Integer> numbers9 = Arrays.asList(1, 2, 3, 4, 5);
        Map<String, Double> result =numbers9.stream().collect(Collectors.teeing(
                        Collectors.summingDouble(n -> n),
                        Collectors.averagingDouble(n -> n),
                        (sum1, avg) -> Map.of("Sum", sum1, "Average", avg)));
        System.out.println(result);
    }

}
