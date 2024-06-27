/*Given is an array which contains the binary values in a Sorted manner. Write the algorithm to find the number of 1’s. */
package Practice;

public class count1s {
    public static int countones(int[] arr)
    {
      int start=findstart(arr,0,arr.length-1);
      int count=0;
      while(start<arr.length)
      {
        count++;
      }
      
      return count;

    }
    
    public static int findstart(int[] arr,int start,int end)
    {
      if (start == end - 1 && arr[start] == 1) {
        return end; // Entire array contains only 1s
      }
      int mid=start+(end-start)/2;
      while(start!=end)
      {
        mid=start+(end-start)/2;
        if(arr[mid]==0)
        {
          findstart(arr,mid+1,end);
        }
        else
        {
          findstart(arr,start,mid);
        }
      }
      return mid;
      
    }
  
    public static void main(String[] args) {
      int[] arr={0,0,0,1,1,1,1,1};
      System.out.println("number of ones = "+countones(arr));
  }
}