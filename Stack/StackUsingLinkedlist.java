package Practice.Stack;
class node
  {
    int val;
    node next;
    node(int data)
    {
      val=data;
      next=null;
    }
  }

public class StackUsingLinkedlist{

  node head;
  node top;
  StackUsingLinkedlist()
  {
    head=new node(0);
    top=head;
  }

  boolean isempty() 
  {
    if(top==head)
      return true;
    else
      return false;
  }

  void push(int val)
  {
    node newnode=new node(val);
    newnode.next=top;
    top=newnode;
  }

  void show()
  {
    node tempnode=top;
    while (tempnode!=head) {
      System.out.println("--> "+tempnode.val);    
      tempnode=tempnode.next;
    }
  }
  
    public static void main(String[] args) {
      StackUsingLinkedlist s1=new StackUsingLinkedlist();
      s1.push(10);
      s1.push(20);
      s1.push(30);
      s1.push(40);
      s1.show();
  }
}