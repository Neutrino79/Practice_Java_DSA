package Practice.Stack;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
_________________________________________________________________________________________
Practice in java:
 */
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";

        System.out.println("Input: " + s1 + " Output: " + isValid(s1));
        System.out.println("Input: " + s2 + " Output: " + isValid(s2));
        System.out.println("Input: " + s3 + " Output: " + isValid(s3));
    }

    public static boolean isValid(String s) {
        Stack<Character> s1=new Stack<>();
        char[] bracket=s.toCharArray();
        for(int i=0 ; i<bracket.length ; i++)
        {
            if(bracket[i]=='(' || bracket[i]=='[' || bracket[i]=='{')
            {
                s1.push(bracket[i]);
            }
            else if(s1.peek()==bracket[i])
            {
                s1.pop();
            }
        }
        if(s1.isEmpty())
            return true;
        else
            return false;
    } 
}

