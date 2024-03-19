#include <iostream>
#include <vector>

using namespace std;

void display(const vector<int>& arr)
{
    cout << "Array: ";
    for (int i = 0; i < arr.size(); ++i)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

int binarySearch(const vector<int>& arr, int num)
{
    int low = 0;
    int high = arr.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] < num) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return -1;
}

int main()
{
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter the array elements:\n";
    for (int i = 0; i < n; ++i) 
    {
        cin >> arr[i];
    }

    // Call the display function
    display(arr);

    cout << "Enter the number you want to search: ";
    int num;
    cin >> num;

    int index = binarySearch(arr, num);
    int position = index + 1;

    if (index != -1) {
        cout << "Element found at index " << index << " in the array.\n";
        cout << "Element found at position " << position << " in the array.\n";
    } else {
        cout << "Element not found in the array.\n";
    }

    return 0;
}
