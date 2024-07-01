package Practice.Array;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr={6,3,5,1,8,2,7,2,2,3,1};

        int largest=arr[0];
        int slargest=-1;
        for(int i=0 ; i<arr.length ; i++)
        {
            if(arr[i]>largest)
            {
                slargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>slargest && arr[i]<largest)
            {
                slargest=arr[i];
            }
        }
        System.out.println("largest = "+largest);
        System.out.println("second largest = "+slargest);

    }
}
