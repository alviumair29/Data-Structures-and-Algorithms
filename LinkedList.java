// Describe a method for performing a card shuffle of a list of 2n elements, by
// converting it into two lists. A card shuffle is a permutation where a list L is cut
// into two lists, L1 and L2, where L1 is the first half of L and L2 is the second half
// of L, and then these two lists are merged into one by taking the first element in
// L1, then the first element in L2, followed by the second element in L1, the second
// element in L2, and so on.

/* LinkedList.java
   Name: Umairuddin Alvi
 * Student # 218137927
 */


import java.util.Scanner;

public class LinkedList {

    Node head; // Head of the list
    static class Node {

        int data;
        Node next;
    
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //Inserting data into the linked list
    public static LinkedList insert(LinkedList card, int data)
    {
    
        Node new_node = new Node(data);
        new_node.next = null;
 
        if (card.head == null) {
            card.head = new_node;
        }
        else {
          
            Node last = card.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }    
        return card;
    }
    public static Node findMiddleNode(LinkedList card)
    {
      Node slowPointer=card.head;
      Node fastPointer=card.head;
    
      while(fastPointer!=null)
      {
         slowPointer=slowPointer.next;
         fastPointer=fastPointer.next.next;
      } 
      return slowPointer;
    }
  
    public static LinkedList shuffle(LinkedList card)
    {//Divide the list into 2 equal lists
     
      //List L1 head
       Node L1_head=card.head;
     
       //List L2_head
       Node L2_head=findMiddleNode(card);
       
      //Current pointer to traverse the list L1.
      Node L1_currNode=L1_head;
      //Next pointer of current pointer of List L1.
      Node L1_nextptr=L1_currNode.next;
    
      //Current pointer to traverse the list L2.
      Node L2_currNode=L2_head;
      //Next pointer of current pointer of List L2.
      Node L2_nextptr=L2_currNode.next;
    
      while(L2_nextptr!=null)
      {
        //Exchange the link between List L1 and L2.
        L1_currNode.next=L2_currNode;
        L2_currNode.next=L1_nextptr;
    
        //Incrementing the list L1 pointers.
        L1_currNode=L1_nextptr;
        L1_nextptr=L1_nextptr.next;
      
        //Incrementing the list L2 pointers.
        L2_currNode=L2_nextptr;
        L2_nextptr=L2_nextptr.next;
     
      }
       //Exchange the last node links of List L1 and L2.
       L1_currNode.next=L2_currNode;
       L2_currNode.next=null;
    
       //retrun the reference of head.
      return card;
    }
    public static void printList(LinkedList card)
    {
        Node currNode = card.head;

        System.out.print("Card: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");         
            currNode = currNode.next;
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        //Empty List
        LinkedList card = new LinkedList();
      
        //Extract data from user to insert into linked list
        //For example purposes, we will have the user enter 8 numbers
        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());
        
        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());
        
        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("Enter data: ");
        card = insert(card, input.nextInt());

        System.out.println("\n");
           
        printList(card);
        card=shuffle(card);
        System.out.println("\n\nAfter shuffle: ");
        printList(card);   
    }
}