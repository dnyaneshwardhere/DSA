#include <iostream>
#include <vector>

using namespace std;

// Function to perform partition
int partition(vector<int>& array, int low, int high) 
{
    // Initialize the pivot element at index 0 (1st element of the array)
    int pivot = array[low];

    int start = low + 1;
    int end = high;

    // Comparing and rearranging elements
    while (start <= end) 
    {
        // Move the start pointer to the right until finding an element greater than pivot
        while (start <= end && array[start] <= pivot) 
        {
            start++;
        }

        // Move the right pointer to the left until finding an element lesser than pivot
        while (start <= end && array[end] > pivot) 
        {
            end--;
        }

        // Swap elements at start and end if start < end
        if (start < end) 
        {
            swap(array[start], array[end]);
        }
    }

    // Swap the pivot with the element at the end
    swap(array[low], array[end]);

    // Return the index where the pivot is newly placed
    return end;
}

// Function to perform QuickSort
void quickSort(vector<int>& array, int low, int high) 
{
    if (low < high) 
    {
        // Partition index or new index where pivot element is placed
        int partitionIndex = partition(array, low, high);

        // Sort the 1st part of the divided array (elements before pivot)
        quickSort(array, low, partitionIndex - 1);

        // Sort the 2nd part of the divided array (elements after pivot)
        quickSort(array, partitionIndex + 1, high);
    }
}

// Function to print the array
void printArray(const vector<int>& array) 
{
    int size = array.size();
    for (int i = 0; i < size; i++) 
    {
        cout << array[i] << " ";
    }
    cout << endl;
}

int main() 
{
    cout << "Enter how many elements you want to sort: ";
    int n;
    cin >> n;

    vector<int> arr(n);

    cout << "Enter elements of the array:" << endl;
    for (int i = 0; i < n; i++) 
    {
        cin >> arr[i];
    }

    cout << "\nOriginal array:" << endl;
    printArray(arr);

    quickSort(arr, 0, n - 1);

    cout << "\nSorted array:" << endl;
    printArray(arr);

    return 0;
}
