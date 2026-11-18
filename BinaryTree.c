#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
} Node;
struct Node *createTree()
{
    int val;
    printf("Enter data (-1 for no node): ");
    scanf("%d", &val);
    if (val == -1)
    {
        return NULL;
    }
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = val;
    printf("Enter left child of %d:\n", val);
    newNode->left = createTree();
    printf("Enter right child of %d:\n", val);
    newNode->right = createTree();
    return newNode;
}
void Inorder(struct Node *root)
{
    if (root != NULL)
    {
        Inorder(root->left);
        printf("%4d", root->data);
        Inorder(root->right);
    }
}
void Preorder(struct Node *root)
{
    if (root != NULL)
    {
        printf("%4d ", root->data);
        Preorder(root->left);
        Preorder(root->right);
    }
}
void Postorder(struct Node *root)
{
    if (root != NULL)
    {
        Postorder(root->left);
        Postorder(root->right);
        printf("%4d ", root->data);
    }
}
int search(struct Node *root, int value)
{
    if (root == NULL)
    {
        return 0;
    }
    if (root->data == value)
    {
        return 1;
    }
    return search(root->left, value);
}
int main()
{
    struct Node *root = createTree();
    printf("Inorder Traversal: ");
    Inorder(root);
    printf("\nPreorder Traversal: ");
    Preorder(root);
    printf("\nPostorder Traversal: ");
    Postorder(root);
    int value;
    printf("\nEnter the value to be searched: ");
    scanf("%d", &value);
    search(root, value);
    if (search(root, value))
    {
        printf("Element %d found in the tree.\n", value);
    }
    else
    {
        printf("Element %d not found in the tree.\n", value);
    }
    return 0;
}
