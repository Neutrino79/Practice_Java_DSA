/*You are tasked with implementing a music playlist application. 
In this application, songs can be added to a playlist, 
and users can navigate through the playlist forward and backward. Additionally, 
users can skip to the next or previous song or remove a song from the playlist using a doubly

Problem Statement
Implement a music playlist using a doubly linked list with the following functionalities:
• Add a song to the end of the playlist: void addSong (String song)
• Remove a song by name: void removeSong (String song)
• Skip to the next song: void next ()
• Go back to the previous song: void previous ()
• Display the current song: String currentSong()
• Display all songs in the playlist: void displayPlaylist()
Input Format
Users will interact with a menu-driven console application:
1. Add Song
2. Remove Song
3. Next Song
4. Previous Song
5. Display Current Song
6. Display Playlist
7. Exit

Output Format
Responses from the application will include confirmations of actions like adding or removing a song,
displaying the current song, or listing all songs in the playlist.

Sample Input
1
Song1
1
Song2
77

Sample Output
Playlist Menu:
1. Add Song
2. Remove Song
3. Next Song
4. Previous Song
5. Display Current Song
6. Display Playlist
7. Exit
Choose an option: Enter song name to add: Added song: Song 1
Playlist Menu:
1. Add Song
2. Remove Song
3. Next Song
4. Previous Song
5. Display Current Song
6. Display Playlist
7. Exit
Choose an option: Enter song name to add: Added song: Song2
Playlist Menu:
1. Add Song
2. Remove Song
3. Next Song
4. Previous Song
5. Display Current Song
6. Display Playlist
7. Exit
Choose an option: Exiting playlist app.          

Explanation of Output:
The sample output demonstrates adding two songs to the playlist and then exiting the application.
 Each option chosen in the input corresponds to an action defined in the menu. */

package Practice.DoubliyLL;

import java.util.Scanner;

class Node
{
    String val;
    Node prev;
    Node next;
    
    Node(String songname)
    {
        val=songname;
        prev=null;
        next=null;
    }
}
class DoublyLinkedList {
    int size=0;
    Node head;
    Node tail;
    Node currSong;
    DoublyLinkedList()
    {
        size=0;
    }
    
    public void addSong(String song)
    {
        Node newNode=new Node(song);
        if(size==0)
        {
            head=newNode;
            tail=newNode;
            currSong=newNode;
        }
        else
        {
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        size++;
    }

    public void removeSong(String song) {
        if (size == 0) {
            System.out.println("No songs to remove");
            return;
        }
        if (size == 1 && head.val.equals(song)) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node tempNode = head;
        while (tempNode != null && !tempNode.val.equals(song)) {
            tempNode = tempNode.next;
        }
        if (tempNode == null) { // not found
            System.out.println("No song found");
            return;
        }
        if (tempNode == head) { // removing head
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (tempNode == tail) { // removing tail
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else { // removing in the middle
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
        }
        size--;
    }
    

    public void nextSong()
    {
        if(size>0 && currSong!=null)
        {
            if(currSong.next!=null)
            {
                currSong=currSong.next;
            }
            else
            {
                System.out.println("There is no song to play next");
            }
        }
        else
        {
            System.out.println("There is no song in previous");
        }
    }

    public void prevSong()
    {
        if(size>0 && currSong!=null)
        {
            if(currSong.prev!=null && size>0)
            {
                currSong=currSong.prev;
            }
            else
            {
                System.out.println("There is no song in previous");
            }
        }
        else
        {
            System.out.println("There is no song in previous");
        }
    }

    public void displaySong()
    {
        if(size>0)
        {
            System.out.println("Current Song = "+currSong.val);
        }
        else
        {
            System.out.println("Playlist is empty");
        }
    }

    public void displayPlaylist()
    {
        Node tempNode=head;
        if(size==0)
        {
            System.out.println("Playlist is empty");
            return;
        }
        while (tempNode!=null) 
        {
            System.out.print("-->"+tempNode.val);   
            tempNode=tempNode.next; 
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        DoublyLinkedList list=new DoublyLinkedList();
        int choice=0;
        while (choice!=7) {
            System.out.println("\n\n1.Add Song");
            System.out.println("2.Remove Song");
            System.out.println("3.Next Song");
            System.out.println("4.Prev Song");
            System.out.println("5.Current Song");
            System.out.println("6.Display Playlist ");
            System.out.println("7.Exit");
            choice=sc.nextInt();
            switch (choice) {
                case 1: System.out.println("Enter Song Name");
                        String Song=sc.next();
                        list.addSong(Song);
                        System.out.println("song "+Song+" Added Successfully");
                    break;

                case 2: System.out.println("Enter Song Name to remove");
                        String Songtoremove=sc.next();
                        list.removeSong(Songtoremove);
                    break;

                case 3:list.nextSong();
                    break;
                
                case 4:list.prevSong();
                    break;
                
                case 5:list.displaySong();
                    break;

                case 6:list.displayPlaylist();
                    break;

                case 7: System.out.println("Exiting Think you");
                    break;

                default:
                    System.out.println("Enter correct choice!!");
                    break;
            }
        }
        sc.close();
    }
    
    
}