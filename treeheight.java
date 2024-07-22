package Practice;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}

public class treeheight {
    Node root = null;

    public void InsertNode(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }

    public void insert(Node root, Node newNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public int calheight(Node root)
    {
        if(root==null || root.val==-1)
        {
            return -1;
        }
        int leftHeight = calheight(root.left);
        int rightHeight = calheight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int nodes = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline character

        System.out.print("Enter the values separated by spaces: ");
        String inputLine = sc.nextLine();
        String[] numberStrings = inputLine.split(" ");
        
        if (numberStrings.length != nodes) {
            System.out.println("The number of values provided does not match the number of nodes specified.");
            sc.close();
            return;
        }

        int[] numbers = new int[nodes];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        treeheight h1 = new treeheight();

        for (int i = 0; i < numbers.length; i++) {
            h1.InsertNode(numbers[i]);
        }

        System.out.println(h1.calheight(h1.root));
        
        System.out.print("Enter the number of nodes: ");
        sc.close();
        
    }
}
