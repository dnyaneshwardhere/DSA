#include <stdio.h>

int arr[4][4];
int visited[4] = {0};
int stack[4];
int top = -1;

void DFS(int vertex){
    visited[vertex] = 1;
    printf("%d visited\n", vertex);
    top++;
    stack[top] = vertex;
    for(int i=0; i<4; i++){
        if(arr[vertex][i] == 1 && !visited[i]){
            DFS(i);
        }
    }
}

int main(){
    for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
            scanf("%d",&arr[i][j]);
        }
    }

    DFS(2);

    printf("\n\n\n%d\n\n", top);

    // while(stack[top] != -1){
    //     for(int i=0; i<4; i++){
    //         if(arr[top][i] == 1 && !visited[i]){
    //             DFS(i);
    //         }
    //         top--;  
    //     }
    // }

    return 0;
}