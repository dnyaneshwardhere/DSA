import java.util.Scanner;

public class Binary_search_iterative
{
    static int searching(int[] arr, int low, int high, int num) 
    {
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] == num) 
            {
                return mid; 
            }

            if (arr[mid] < num) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    static void display(int[] arr) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of an array :");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements :");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array :");
        display(arr);

        System.out.println("\nEnter the number you want to search ?");
        int num = sc.nextInt();

        int low = 0;
        int high = n - 1; 
        int index = searching(arr, low, high, num);
        int position = searching(arr, low, high, num)+1;

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
