#include<stdio.h>
#include<stdlib.h>

void merge(int arr[], int l, int mid, int u)
{
    int i, j, k;
    int n1 = mid - l + 1;
    int n2 = u - mid;

    int L[n1], R[n2];
    for (i=0; i<n1; i++)
    {
        L[i] = arr[l+i];
    }

    for(j=0; j<n2; j++)
    {
        R[j] = arr[mid+1+j];
    }
    i = 0;
    j = 0;
    k = l;

    //merge the temp arrays into arr with sorting
    while(i < n1 && j < n2)
    {
        if(L[i] <= R[j])
        {
            arr[k]=L[i];
            i++;
        }
        else
        {
            arr[k]=R[j];
            j++;
        }
        k++;
    }

    // copying the remaining elements
    while(i<n1)
    {
        arr[k]=L[i];
        i++;
        k++;
    }

    while (j<n2)
    {
        arr[k]=R[j];
        j++;
        k++;
    }
}
void merge_sort(int arr[], int l, int u)
{
    if(l<u)
    {
        int mid=(l+u)/2;
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,u);
        merge(arr,l,mid,u);
    }
}

void printArray(int a[], int size)
{
    for(int i=0; i<size; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
}

int main()
{
    int arr[]={10,55,1,2,6,28};
    int size=sizeof(arr)/sizeof(arr[0]);
    int l=0;
    int u= size-1;

    printf("Given Array :\n");
    printArray(arr, size);

    merge_sort(arr, l, u);

    printf("\nSorted Array :\n");
    printArray(arr, size);
}