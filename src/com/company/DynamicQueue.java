package com.company;

public class DynamicQueue{

  private DynamicNode front, rear;
  private int length = 0; // max length of queue
  private int QUEUESIZE = 4;

  public DynamicQueue(){
    front = null;
    rear = null;
  }

  public boolean empty(){
    return (front == null);
  }

  public DynamicNode getFront() {
    return front;
  }

  public void insert(Object x){

    DynamicNode p = new DynamicNode(x, null);

    if(empty())
      front = p;
    else
      rear.setNext(p);

    rear = p;

  } // end insert

  public Object remove(){

    if(empty()){
      System.out.println("queue underflow");
      System.exit(1);
    }

    DynamicNode p = front;
    Object temp = p.getInfo();
    front = p.getNext();
    if(front == null)
      rear = null;

    return temp;

  } // end remove

  public void searchInsert(Object x) {

    DynamicNode p = front;

    while (p != null) {

      // if current insert is = to element in queue delete element and move to front
      if (x == p.getInfo()) { // do get next and link nodes using a temp variable?
        // if the node is already at the end then and matches do nothing
        if (p.getNext() == null) {
          System.out.print(x + " is already rear. ");
          return;
        }

        System.out.print("Moving " + x + " to rear. ");


        // node pointing to match now points to the matches pointer. Effectively deleting it.
        p.setInfo(p.getNext().getInfo());
        p.setNext(p.getNext().getNext());

        // new rear value
        DynamicNode temp = new DynamicNode(x, null);
        rear.setNext(temp);
        rear = temp;

        return;
      }
      p = p.getNext();
    }

    //System.out.print("|| length of q: " + countQueue() + " ||");
      if (countQueue() >= QUEUESIZE) { // remove element from front then insert new node in rear

        System.out.print("Q is full, removing front. Inserting " + x + " in rear. ");


        front = front.getNext();

        // insert node in rear
        DynamicNode q = new DynamicNode(x, null);
        rear.setNext(q);
        rear = q;

        return;
      }

    System.out.print("Inserting " + x + " in rear. ");

    DynamicNode temp = new DynamicNode(x, null);

    if(empty())
      front = temp;
    else
    rear.setNext(temp);

    rear = temp;

  } // end searchInsert

  public void printQueue() {

    DynamicNode p = front;

    // check if List is empty
    if (p == null) {
      System.out.print("Empty");
    }

    // runs until there are no more values left in queue
    while (p != null) {

      // prints an arrow unless there isn't a next term
      if (p.getNext() != null){
        System.out.print(p.getInfo() + "->");
      } else {
        System.out.print(p.getInfo());
      }

      p = p.getNext();

    }

  }

  public int countQueue() {

    DynamicNode p = front;
    int count = 0;

    while (p != null) {
      count++;

      p = p.getNext();
    }

    return count;
  }

} // end class DynamicQueue
