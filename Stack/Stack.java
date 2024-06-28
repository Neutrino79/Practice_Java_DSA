package Practice.Stack;

public class Stack {
    private int maxsize;
    private int top;
    private int[] stack;

    Stack(int size)
    {
        maxsize=size;
        top=-1;
        stack=new int[maxsize];
    }

    //helper function for check is stack is full
    private boolean isfull()
    {
        if(top==maxsize-1)
            return true;
        else
            return false;
    }
    private void push(int val)
    {
        if(isfull())
            System.out.println("Stack is full..");
        else
            stack[++top]=val;
    }


    //helper function for check is stack is empty
    private boolean isEmpty()
    {
        if(top==-1)
            return true;
        else
            return false;
    }

    private void pop()
    {
        if(isEmpty())
            System.out.println("stack is empty..");
        else
            System.out.println(stack[top--]+" popped");
    }


    //helper function for peeking top elemnt
    private void peek()
    {
        if(isEmpty())
            System.out.println("stack is empty..");
        else
            System.out.println("--> "+stack[top]);
    }

    //helper function for ndisplaying whole stack
    private void DisplayStack()
    {
        for(int i=top ; i>=0 ;i--)
        {
            System.out.println("--> "+stack[i]);
        }
    }

    public static void main(String[] args) {
        Stack s1=new Stack(5);
        System.out.println("\nPushing elements :");
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.DisplayStack();

        System.out.println("\npoppeing element :");
        s1.pop();
        s1.DisplayStack();

        System.out.println("\nPeeking element :");
        s1.peek();

    }
}
