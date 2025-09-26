package org.example.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LiinkedListAdd list=new LiinkedListAdd();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list.addAtHead(sc.nextInt());
        }
        list.print();
    }
}
