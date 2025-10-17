package org.example.Collection;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionPractice {
//    Write code to remove duplicates from a list.
//    Given a list of names, sort them by length using Comparator.
//    Find the frequency of each element in a list.
//    Given two lists, find their intersection.
//    How to make a collection read-only?
//    How to make a collection thread-safe?
//    Write code to iterate over a HashMap in different ways.
//    Write code to find the first non-repeating character using LinkedHashMap.
//    Write code to sort a map by values.
//    Given a stream of integers, remove duplicates and sort in descending order.
    public static void main(String[] args) {
//        Write code to remove duplicates from a list.
        List<Integer> al=new ArrayList<>(Arrays.asList(1,1,2,3,4,5,4,5,7,7));
//        1stwya
//        HashSet<Integer>hashSet=new HashSet<>(al);
//        ArrayList<Integer> ans=new ArrayList<>(hashSet);
//        System.out.println(ans);

//        2nd way
//        System.out.println(al.stream().distinct().collect(Collectors.toList()));

        //    Given a list of names, sort them by length using Comparator.
        List<String> names=new ArrayList<>(Arrays.asList("Akash","Sunny","Ap","Bob","Ramesh","RAM","Manju"));
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        });
//        names.sort((s1,s2)->Integer.compare(s1.length(),s2.length()));
//        System.out.println(names);


//        Given two lists, find their intersection.
//        List<String> list1 = Arrays.asList("A", "B", "C", "D", "A");
//        List<String> list2 = Arrays.asList("B", "D", "E", "F", "B");
//        Set<String>s1=new HashSet<>(list1);
//        Set<String>s2=new HashSet<>(list2);
//        s1.retainAll(s2);
//
//        System.out.println(s1);


        //    How to make a collection read-only?
//        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "A"));
//        List<String> nomodfiable=Collections.unmodifiableList(list1);
//        System.out.println(nomodfiable);
//        list1.add("J");
//        System.out.println(nomodfiable);
//        if you modify the orginal list then nomodfiable list will also get modified

//        Scenario: You’re asked to store employee records in such a way that employee IDs are unique and easily searchable.
//        What would you use?
//        HashMap since we can take id as key and it will be unique no duplicates values allowed
//        and it will give the result in search in map is o(1);
          Map<Integer,Employee> map=new HashMap<>();

          map.put(1,new Employee("Akash","Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS"))));
          map.put(2,new Employee("Sunny","Developer",new ArrayList<>(Arrays.asList("Java","AWS","Spring","Junit")) ));
          map.put(3,new Employee("Aravind","Developer",new ArrayList<>(Arrays.asList("Python","AWS","Node JS","React","LLM"))));
          map.put(4,new Employee("Ashwik ","DCTO DB",new ArrayList<>(Arrays.asList("DB","React","Node JS"))));
          map.put(5, new Employee("Jayasurya ", "CTO IT", new ArrayList<>(Arrays.asList("IT", "AWS", "FIREWALL", "WAF"))));
          for (Map.Entry<Integer, Employee> m:map.entrySet()){
//              System.out.println("ID: "+ m.getKey()+" name :  "+m.getValue().name+" department:  "+m.getValue().getDepartment()
//              +" Skills :"+ m.getValue().skills);
              ListIterator<String>  printSkills=m.getValue().getSkills().listIterator();
              while (printSkills.hasNext()) {
                  System.out.print("Name: "+m.getValue().getName()+" Skills:"+printSkills.next()+"\n");
              }
          }

          List<Map.Entry<Integer,Employee>>unsortedlist1=new ArrayList<>();
          for(Map.Entry<Integer,Employee>m:map.entrySet()){
              unsortedlist1.add(m);
          }
          Collections.sort(unsortedlist1, new Comparator<Map.Entry<Integer, Employee>>() {
              @Override
              public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
                  return o2.getValue().getSkills().size()-o1.getValue().getSkills().size();
              }
          });
          Map<Integer ,Employee>sortedmap=new LinkedHashMap<>();
        for(Map.Entry<Integer,Employee> sorted:unsortedlist1){
            sortedmap.put(sorted.getKey(),sorted.getValue());
        }
//        for (Map.Entry<Integer, Employee> m:sortedmap.entrySet()){
//              System.out.println("ID: "+ m.getKey()+" name :  "+m.getValue().name+" department:  "+m.getValue().getDepartment()
//              +" Skills :"+ m.getValue().skills);
//        }

        HashMap<Integer,Employee> hashMap=new HashMap<>();
        for (Map.Entry<Integer, Employee> m:sortedmap.entrySet()){
              if(m.getValue().getSkills().contains("React")){
                  hashMap.put(m.getKey(),m.getValue());
              }
        }

        for (Map.Entry<Integer, Employee> m:hashMap.entrySet()){
            System.out.println("ID: "+ m.getKey()+" name :  "+m.getValue().name+" department:  "+m.getValue().getDepartment()
                    +" Skills :"+ m.getValue().skills);
        }

//
//          for(Map.Entry<Integer,Employee>m:map.entrySet()){
//              if(m.getValue().getDepartment().equals("CTO IT"))
//                  System.out.println(m.getValue().name);
//          }




//          Map<String,Integer> Employees=new HashMap<>();
//            Employees.put("Akash",28);
//            Employees.put("Sunny", 35);
//            Employees.put("Aravind",27);
//            Employees.put("Jayasurya",29);
//            Employees.put("Ashwik ",26);
//            Employees.put("BOB",25);
//            Employees.put("Ram", 24);
//            Employees.put("Saurav",27);
//            Employees.put("Alice",50);
//            Employees.put("John",45);
//
//        List<Map.Entry<String, Integer> > list =
//                new LinkedList<Map.Entry<String, Integer> >();
//            for(Map.Entry<String,Integer> m: Employees.entrySet()){
//                list.add(m);
//
//            }
//
////            System.out.println(list);
//            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//                @Override
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return o1.getValue().compareTo(o2.getValue());
//                }
//            });
//
//        Map<String ,Integer>sortedmap=new LinkedHashMap<>();
//        for(Map.Entry<String,Integer> sorted:list){
//            sortedmap.put(sorted.getKey(),sorted.getValue());
//        }
//        System.out.println(sortedmap);

//        Sort a list of Employee objects by name (using Comparable) and by salary (using Comparator).
            ArrayList<Employee> al1=new ArrayList<>();
            al1.add(new Employee("Akash","Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS")),90000));
            al1.add(new Employee("Sunny","Developer",new ArrayList<>(Arrays.asList("Java","AWS","Spring","Junit")),1200000 ));
            al1.add(new Employee("Aravind","Developer",new ArrayList<>(Arrays.asList("Java","AWS","Spring","Junit")),120000 ));
            al1.add(new Employee("Ashwik","Developer",new ArrayList<>(Arrays.asList("Java","AWS","Spring","Junit")),90000 ));
            al1.add(new Employee("Jayasura","Developer",new ArrayList<>(Arrays.asList("Java","AWS","Spring","Junit")),10002342 ));


//            Collections.sort(al1, new Comparator<Employee>() {
//                @Override
//                public int compare(Employee o1, Employee o2) {
//                    return o1.getSalary().compareTo(o2.getSalary());
//                }
//            });
//
//            ListIterator<Employee>employeeListIterator=al1.listIterator();
//            while(employeeListIterator.hasNext()){
//                Employee e=employeeListIterator.next();
//                System.out.println(e.getName() +"Salary :"+ e.getSalary());
//            }
            Collections.sort(al1);
                    ListIterator<Employee>employeeListIterator=al1.listIterator();
            while(employeeListIterator.hasNext()){
                Employee e=employeeListIterator.next();
                System.out.println(e.getName() +"Salary :"+ e.getSalary());
            }
//        Create a LinkedHashMap to store student roll numbers and names, and print them in the order they were inserted.
            LinkedHashMap<Integer,String>studentsMap=new LinkedHashMap<>();
            studentsMap.put(1,"Akash");
            studentsMap.put(35,"Sunny");
            studentsMap.put(27,"Aravind");
            studentsMap.put(29,"Jayasurya");
            studentsMap.put(2,"Ashwik ");
            studentsMap.put(25,"BOB");
            for(Map.Entry<Integer,String>m:studentsMap.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }
            //To copy to other map we can use map.putAll(map)
          LinkedHashMap<Integer,String>studentsMap2=new LinkedHashMap<>();
            studentsMap2.putAll(studentsMap);

           TreeMap<Employee,Integer>tree=new TreeMap<>();
           tree.put(new Employee("Akash","Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS")),90000),1);
           tree.put(new Employee("Sunny","Backend Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS")),1190000),2);
           tree.put(new Employee("Aravind","Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS")),150000),3);
           tree.put(new Employee("Jayasurya","CTO",new ArrayList<>(Arrays.asList("Java","React","Node JS")),80000),4);
           tree.put(new Employee("Ashwik","DCTO DB ",new ArrayList<>(Arrays.asList("Java","React","Node JS")),60000),5);
           tree.put(new Employee("BOB","Developer",new ArrayList<>(Arrays.asList("Java","React","Node JS")),90000),6);

           for(Map.Entry<Employee,Integer>map1:tree.entrySet()){
               System.out.println(map1.getKey().getName()+" "+map1.getValue());
           }


    }

}
