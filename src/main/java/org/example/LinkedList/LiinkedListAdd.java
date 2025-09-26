package org.example.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LiinkedListAdd {

    Node head;
    int size;

    public LiinkedListAdd() {
        this.head=null;
        this.size=0;


    }
    public Node reverseList(Node head) {
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node  temp=curr.next;    //step1
            curr.next=prev;              //step2
            prev = curr;                //step3
            curr=temp;                   //step4
        }
        return prev;
    }
    public void addAtHead(int val){
        Node newNode=new Node(val);
        newNode.next=this.head;
        this.head=newNode;
        size++;
    }
    public void addAtTail(int val) {

        Node curr=this.head;
        Node newNode=new Node(val);
        if(this.head==null){
            this.head=newNode;
        }
        while(curr!=null){
            curr=curr.next;
        }
        curr.next=newNode;
        size++;

    }
    public void print(){
        Map<Node,Integer> m=new HashMap();

        Node curr=this.head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
    }
    public Node RemoveNthNode(Node head,int n){
        int count=0;
        Node temp=head;
        Node curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==n){
          Node  newHead=head.next;
          return newHead;
        }
        int res=count-n;
        while(temp!=null){
         res--;
         if(res==0)
             break;
         temp=temp.next;
        }
        Node deleteNode= temp.next;
        temp.next=temp.next.next;
        return head;
    }

    public Node oddEvenList(Node head) {
        Node odd=head;
        Node even=head;
        Node  evenstart=even.next;
        while(odd.next!=null&& even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenstart;
        return odd;

    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node CurrentHead1=l1;
        Node CurrentHead2=l2;
        Node dummyNode=new Node(-1);
        Node curr=dummyNode;
        int carry=0;
        int sum=0;
        while(CurrentHead1!=null && CurrentHead2!=null){
            sum=carry;
            if(CurrentHead1!=null)
            {
                sum+=CurrentHead2.val;
            }
            if(CurrentHead2!=null)
            {
                sum+=CurrentHead2.val;
            }
            Node newNode =new Node(sum%10);
            carry=sum/10;
            curr.next=newNode;
            curr=curr.next;

            if(CurrentHead1!=null)
                CurrentHead1=CurrentHead1.next;
            if(CurrentHead2!=null)
                CurrentHead2=CurrentHead2.next;

        }

        if(carry>0){
            Node newNode =new Node(carry);
            curr.next=newNode;
        }
        return dummyNode.next;

    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp1=list1;
        Node temp2=list2;
        Node DummyNode=new Node(-1);
        Node curr=DummyNode;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                Node newNode=new Node(temp1.val);
                curr.next=newNode;
                curr=curr.next;
                temp1=temp1.next;
            }
            else if (temp2.val <= temp1.val){
                Node newNode=new Node(temp2.val);
                curr.next=newNode;
                curr=curr.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            Node newNode=new Node(temp1.val);
            curr.next=newNode;
            curr=curr.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            Node newNode=new Node(temp2.val);
            curr.next=newNode;
            curr=curr.next;
            temp2=temp2.next;
        }
        return DummyNode.next;
    }
    public Node rotateRight(Node head, int k) {
        if(head==null ||k==0)
            return head;
        int size=1;
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
            size++;
        }
        if(k%size==0)
            return head;
        k=k%size;
        tail.next=head;
        Node newlatsNode=findNthNode(head,size-k);
        head =newlatsNode.next;
        newlatsNode.next=null;
        return  newlatsNode.next;
    }
    public  Node findNthNode(Node temp,int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k) {
                return temp;
            }
            cnt++;
            temp=temp.next;
        }
        return temp;

    }


    public Node swapPairs(Node head) {
        Node dummyNode=new  Node(0);
        dummyNode.next=head;
        Node point=dummyNode;

        while (point.next!=null &&point.next.next!=null){
            Node swap1=point.next;
            Node swap2=point.next.next;

            swap1.next=swap2.next;
            swap2.next=swap1;
            point.next=swap2;
            point =swap1;
        }
        return dummyNode.next;


    }

}
