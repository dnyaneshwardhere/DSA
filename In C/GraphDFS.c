#include<stdio.h>

int arr[4][4];
int visited[4]={0};
int stack[4];
int top=-1;

void DFS(int vertex)
{
    visited[vertex]=1;
    printf("%d\t", vertex);
    top++;
    stack[top]=vertex;
    for(int i=1; i<4; i++)
    {
        if(arr[vertex][i]==1 && !visited[i])
        {
            DFS(i);
            break;
        }
    }
}

int main()
{
    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }
    DFS(0);

    printf("Stack is :\n");
    for(int i=0; i<4; i++)
    {
        printf("%d",stack[i]);
    }   
    
}