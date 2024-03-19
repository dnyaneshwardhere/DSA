import java.util.Scanner;

public class QuickSort 
{
    public static void quickSort(int[] array, int low, int high) 
    {
        if (low < high) 
        {
            // partition index or new index where pivot element placed
            int partitionIndex = partition(array, low, high);

            //It is for sorting the 1st part of divided array when pivot move from it's position   
            quickSort(array, low, partitionIndex - 1);

            //It is for sorting the 2nd part of divided array when pivot move from it's position   
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) 
    {
        //initialize the pivot element at index 0 that means the 1st element of an array
        int pivot = array[low];
        int start = low + 1;
        int end = high;

        while (start <= end) 
        {
            // Move the start pointer to the right until finding the greater element than pivot
            while (start <= end && array[start] <= pivot) 
            {
                start++;
            }
            // Move the right pointer to the left until finding the lesser element than pivot
            while (start <= end && array[end] > pivot) 
            {
                end--;
            }
            // when we get the greater and lesser values Swap the elements (start and end)
            if (start < end) 
            {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        // Either if the index of start is greater than indeex of end then swap (end and p)
        int temp = array[low];
        array[low] = array[end];
        array[end] = temp;

        // Return the index where the pivot is newly placed
        return end;
    }

    public static void printArray(int a[], int n) 
    {
        int size = n;
        for (int i = 0; i < size; i++) 
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many element do you want to sorts ?");
        int n=sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of Array :");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();

        }
        System.out.println("\nOriginal array: ");
        printArray(arr, n);

        quickSort(arr, 0, n - 1);

        System.out.println("\nSorted array: " );
        printArray(arr, n);

        sc.close();
    }
}
