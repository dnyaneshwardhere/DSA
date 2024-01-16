#include<stdio.h>
#include <stdlib.h>

#define size 4;

int front=-1;
int rear=-1;
int visited[4]={0};
int queue[4];
int adjMatrix[4][4];

void BFS(int curretVertex)
{
    printf("Visited :%d\n", curretVertex);
    front++;

    for(int i=0; i<4; i++)
    {
        if(!visited[i] && !adjMatrix[curretVertex][i])
        {
            rear++;
            queue[rear]=i;
            visited[i]=1;
        }
    }

    BFS(queue[front]);
}


int main()
{
    printf("Enter the Adjacancy Matrix:\n");
    for(int i=0; i<4; i++)
    {
        for(int j=0; j<4; j++)
        {
            scanf("%d", &adjMatrix[i][j]);
        }
    }

    front++;
    rear++;

    queue[rear]=0;
    visited[0]=1;
    printf("\nBreadth First Search Traversal of Graph \n");
    BFS(0);
    return 0;
}