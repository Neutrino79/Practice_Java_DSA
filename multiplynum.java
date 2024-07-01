package Practice;
import java.util.Scanner;

public class multiplynum {
    private static int Multiplynum(int num, int mult) {
        int res=0;
        for(int i=1 ; i<=mult ; i++)
        {
            res+=num;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the num");
        int num=sc.nextInt();
        System.out.println("Enter the multiplier");
        int mult=sc.nextInt();

        System.out.println("Result = "+Multiplynum(num,mult));
        sc.close();
    }

    
}