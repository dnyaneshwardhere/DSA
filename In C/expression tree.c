#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

struct TreeNode 
{
    char data;
    struct TreeNode* left;
    struct TreeNode* right;
};

int isOperand(char c) 
{
    return isalnum(c);
}

struct TreeNode* createNode(char data) 
{
    struct TreeNode* newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

struct TreeNode* constructExpressionTreePostfix(char postfix[]) 
{
    struct TreeNode* stack[50]; 
    int top = -1;

    for (int i = 0; postfix[i] != '\0'; i++) 
    {
        if (isOperand(postfix[i])) 
        {
            stack[++top] = createNode(postfix[i]);
        } 
        
        else 
        {
            struct TreeNode* operand2 = stack[top--];
            struct TreeNode* operand1 = stack[top--];

            struct TreeNode* operatorNode = createNode(postfix[i]);
            
            operatorNode->left = operand1;
            operatorNode->right = operand2;

            stack[++top] = operatorNode;
        }
    }
    return stack[0];
}

void recursiveInOrderTraversal(struct TreeNode* root) 
{
    if (root != NULL) 
    {
        recursiveInOrderTraversal(root->left);
        printf("%c ", root->data);
        recursiveInOrderTraversal(root->right);
    }
}

void recursivePreOrderTraversal(struct TreeNode* root) 
{
    if (root != NULL) 
    {
        printf("%c ", root->data);
        recursivePreOrderTraversal(root->left);
        recursivePreOrderTraversal(root->right);
    }
}

void recursivePostOrderTraversal(struct TreeNode* root) 
{
    if (root != NULL) 
    {
        recursivePostOrderTraversal(root->left);
        recursivePostOrderTraversal(root->right);
        printf("%c ", root->data);
    }
}

int main() 
{
    char postfixExpression[50];
    printf("Enter the postfix expression: ");
    scanf("%s", postfixExpression);

    struct TreeNode* root = constructExpressionTreePostfix(postfixExpression);

    printf("Recursive In-Order Traversal: ");
    recursiveInOrderTraversal(root);
    printf("\n");

    printf("Recursive Pre-Order Traversal: ");
    recursivePreOrderTraversal(root);
    printf("\n");

    printf("Recursive Post-Order Traversal: ");
    recursivePostOrderTraversal(root);
    printf("\n");

    free(root);
    return 0;
}
