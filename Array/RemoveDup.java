package Practice.Array;

public class RemoveDup {
   
    //two pointer concept 
    public static void main(String[] args) {
        int [] arr={1,1,4,5,6,6,8,8,8,9,10,10};
        int curr=0;
        int check=1;
        while (check<arr.length) {
            if(arr[curr]!=arr[check])
            {
                arr[++curr]=arr[check];
            }
            check++;
        }
        for(int i=0 ; i<=curr ; i++ )
        {
            System.out.print(" "+arr[i]);
        }
    }
}
