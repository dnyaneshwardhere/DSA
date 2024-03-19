import java.util.Scanner;

public class Bianry_search_recursive 
{
    static int binary_search(int[] arr, int low, int high, int num)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(arr[mid]==num)
            {
                return mid;
            }
            else if(arr[mid] > num)
            {
                //high = mid-1
                return binary_search(arr, low, mid-1, num); 
            }

            // when arr[mid] < num
            else 
            {
                //low = mid+1
                return binary_search(arr, mid+1, high, num);
            }
        }
        return -1;
    }
    static void display(int[] arr)
    {
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array :");
        int  n=sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of an array :");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array :");
        display(arr);
        
        System.out.println("\nElement to be searched is :");
        int num = sc.nextInt();
    
        int low = 0;
        int high = n-1;
        int index = binary_search(arr, low, high, num);
        int position = binary_search(arr, low, high, num)+1;

        if (index != -1) 
        {
            System.out.println("Element is present at index position " + index);
            System.out.println("Element is present at array position " + position);
        } 
        else 
        {
            System.out.println("Element is not present in the array.");
        }

        sc.close();
    }
    
}
