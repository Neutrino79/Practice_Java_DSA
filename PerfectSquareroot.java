import java.util.Scanner;

public class PerfectSquareroot {
    static int Sqrt(int x)
    {
        int i = 1;
        while(i<x/2){
        int mul=i*i;
        if(mul==x)
        {
            return i;
        }
        i++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int num;
        System.out.println("Enter number to find perfect square root :");
        Scanner sc= new Scanner(System.in);
        num=sc.nextInt();
        System.out.println("Perfect Square root of "+num+" = "+Sqrt(num));
    }
}

