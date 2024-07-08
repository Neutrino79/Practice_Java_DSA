/*Scenario
You are tasked with implementing a browsing history manager for a web browser.
 This application allows users to visit new web pages, navigate back to previous pages, and forward to the next pages. 
 The implementation should use a doubly linked list.

Problem Statement
Implement a browsing history manager using a doubly linked list with the following functionalities:
• Visit a new page: void visit (String url)
• Go back to the previous page: void back()
• Go forward to the next page: void forward()
• Display the current page: String currentPage ()
• Display all pages in the history: void displayHistory ()

Explanation
A browsing history manager should manage a user's web navigation similar to how modern web browsers do.
 Using a doubly linked list allows easy navigation both forwards and backwards through the user's history.
Input Format
Commands will be entered through a menu-driven interface:
• 1 : Visit a new page (followed by the URL)
• 2 : Go back
• 3 : Go forward
• 4 : Display the current page
• 5 : Display history
• 6 : Exit.   

Output Format
Outputs vary based on the action taken, such as showing the current page, the full history, or confirmation of navigation.
Sample Input
www.example.com
www.google.com
2
4
6
6

Sample Output
Browsing History Menu:
1. Visit New Page
2. Back
3. Forward
4. Display Current Page
5. Display History
6. Exit
Choose an option: Enter URL to visit: Visited: www.example.com
Browsing History Menu:
1. Visit New Page
2. Back
3. Forward
4. Display Current Page
5. Display History
6. Exit.     
Choose an option: Enter URL to visit: Visited: www.google.com
Browsing History Menu:
1. Visit New Page
2. Back
3. Forward
4. Display Current Page
5. Display History
6. Exit
Choose an option: Moved back to: www.example.com
Browsing History Menu:
1. Visit New Page
2. Back
3. Forward
4. Display Current Page
5. Display History
6. Exit
Choose an option: Current page: www.example.com
Browsing History Menu:
1. Visit New Page
2. Back
3. Forward
4. Display Current Page
5. Display History
6. Exit
Choose an option: Exiting browsing history manager.
Explanation of Output
After visiting two pages and then moving back, the output confirms each action and displays the current page. */

package Practice.DoubliyLL;

import java.util.Scanner;

class Node
{
    Node prev;
    Node next;
    String val;
    Node(String site)
    {
        val=site;
        prev=null;
        next=null;
    }

}

public class BrowserHistory {
    int size=0;
    Node head;
    Node tail;
    Node current;
    int back=0;

    public void visit(String site)
    {
        Node newnNode=new Node(site);
        if(size==0)
        {
            head=newnNode;
            tail=newnNode;
            current=newnNode;
            size++;
        }
        else
        {
            current.next=newnNode;
            newnNode.prev=current;
            current=current.next;
            tail=current;
            size=size-(back-1);
        }
        
    }
    
    public void back()
    {
        if(size==0 || size==1 || current.prev==null)
        {
            System.out.println("No Tab present in Back");
        }
        else
        {
            current=current.prev;
            back++;
        }
    }

    public void forward()
    {
        if(current==tail)
        {
            System.out.println("No Tab present to forward");
        }
        else
        {
            current=current.next;
            back--;
        }
    }

    public String currentPage()
    {
        if(size==0)
        {
            return "No Page is present";
        }
        else
        {
            return "current page :"+current.val;
        }
    }
    public void displayHistory()
    {
        if(size==0)
        {
            System.out.println("No pages are present in the history");
        }
        else
        {
            Node tempNode=head;
            while (tempNode!=tail.next)
            {
                if(tempNode==current)
                {
                    System.out.println(" --> "+tempNode.val+" (Current Page)");
                }
                else
                {
                System.out.println(" --> "+tempNode.val);
                }
                tempNode=tempNode.next;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        BrowserHistory browser=new BrowserHistory();
        int choice=0;
        do
        {
            System.out.println("\n\nMenu");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Display Current Page");
            System.out.println("5. Display History");
            System.out.println("6. Exit");
            System.out.println("Please choose Choice");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Site Address :");
                    String site=sc.next();
                    browser.visit(site);
                    break;
            
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    System.out.println(browser.currentPage());
                    break;
                case 5:
                    browser.displayHistory();
                    break;
                case 6:
                    System.out.println("Exiting");
                default:
                    System.out.println("Enter correct coice");
                    break;
            }
        }while(choice!=6);
        sc.close();
    }

}
