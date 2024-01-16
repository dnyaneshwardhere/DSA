#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& arr, int l, int mid, int u) {
    int i, j, k;
    int n1 = mid - l + 1;
    int n2 = u - mid;

    vector<int> L(n1);
    vector<int> R(n2);

    for (i = 0; i < n1; i++) {
        L[i] = arr[l + i];
    }

    for (j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }

    i = 0;
    j = 0;
    k = l;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(vector<int>& arr, int l, int u) {
    if (l < u) {
        int mid = (l + u) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, u);
        merge(arr, l, mid, u);
    }
}

void printArray(const vector<int>& arr) {
    int size = arr.size();
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int n, x;
    cout << "Enter how many elements do you want to sort?" << endl;
    cin >> n;

    vector<int> arr;
    cout << "Enter the elements:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> x;
        arr.push_back(x);
    }

    int size = arr.size();
    int l = 0;
    int u = size - 1;

    cout << "Given Array :" << endl;
    printArray(arr);

    mergeSort(arr, l, u);

    cout << "\nSorted Array :" << endl;
    printArray(arr);

    return 0;
}
