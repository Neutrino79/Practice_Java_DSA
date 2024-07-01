package Practice;

import java.util.Scanner;

/**
 * Search2Dmatrix
 */
public class Search2Dmatrix {

    private static String search2Dmatrix(int[][] arr, int row, int col,int start,int end,int key) {
        
    } 

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter rows");
        int m=sc.nextInt();
        
        System.out.println("enter columns");
        int n=sc.nextInt();

        int[][] arr=new int[m][n];
        System.out.println("Enter elements");
        for(int i=0 ; i<m ; i++)
        {
            for(int j=0 ; i<n ; j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println("Enter Key");
        int key=sc.nextInt();

        System.out.println("result="+search2Dmatrix(arr,m,n,0,arr.length,key));
        sc.close();
    }

   
}