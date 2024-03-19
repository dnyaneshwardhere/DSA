#include <iostream>
using namespace std;

int binary_search(int arr[], int low, int high, int num)
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
void display(int arr[], int size)
{
    for(int i=0; i<size;i++)
    {
        cout << arr[i] << " ";
    }
}

int main() 
{
    int n;
    cout << "Enter the size of an array :";
    cin >> n;

    int arr[n];
    cout << "Enter elements of an array :";
    for(int i=0; i<n; i++)
    {
        cin >> arr[i];
    }

    cout << "Array :";
    display(arr, n);
    
    cout << "\nElement to be searched is :";
    int num;
    cin >> num;

    int low = 0;
    int high = n-1;
    int index = binary_search(arr, low, high, num);
    int position = binary_search(arr, low, high, num)+1;

    if (index != -1) 
    {
        cout << "Element is present at index position " << index << endl;
        cout << "Element is present at array position " << position << endl;
    } 
    else 
    {
        cout << "Element is not present in the array." << endl;
    }

    return 0;
}