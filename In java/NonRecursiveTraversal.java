import java.util.*;

// Constructing Node
class Node 
{
    int data;
    Node left, right;

    public Node(int data) 
	{
        this.data = data;
        left = right = null;
    }
}

public class NonRecursiveTraversal 
{
    Node root;

    // Non Recursive Inorder Traversal Function
    public void Inorder() 
	{
        if (root == null) 
		{
            System.out.println("Empty!!");
        } 
		else 
		{
            Stack<Node> stack = new Stack<Node>();
            Node current = root;

            while (!stack.isEmpty() || current != null) 
			{
                if (current != null) 
				{
                    stack.push(current);
                    current = current.left;
                } 
				else 
				{
                    current = stack.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    // Non Recursive Preorder Traversal Function
    public void Preorder() 
	{
        if (root == null) 
		{
            System.out.println("Empty!!");
        } 
		else 
		{
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);

            while (!stack.isEmpty()) 
			{
                Node current = stack.pop();
                System.out.print(current.data + " ");

                /* Pushing right first and then left into the stack */
                if (current.right != null) 
				{
                    stack.push(current.right);
                }
                if (current.left != null) 
				{
                    stack.push(current.left);
                }
            }
        }
    }

    // Non Recursive Postorder Traversal Function
    public void Postorder() 
	{
        if (root == null) 
		{
            System.out.println("Empty!!");
        } 
		else 
		{
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.push(root);

            while (!stack1.isEmpty()) 
			{
                Node current = stack1.pop();
                stack2.push(current);

                /* Pushing left first and then right into the stack */
                if (current.left != null) 
				{
                    stack1.push(current.left);
                }
                if (current.right != null) 
				{
                    stack1.push(current.right);
                }
            }

            while (!stack2.isEmpty()) 
			{
                Node current = stack2.pop();
                System.out.print(current.data + " ");
            }
        }
    }

    // Main Method
    public static void main(String args[]) 
	{
        Scanner sc = new Scanner(System.in);
        int choice;

        NonRecursiveTraversal Traversal = new NonRecursiveTraversal();
        Traversal.root = new Node(3);
        Traversal.root.left = new Node(5);
        Traversal.root.right = new Node(7);
        Traversal.root.left.left = new Node(4);
        Traversal.root.left.right = new Node(1);

        do 
		{
            System.out.println("\n******Non-Recursive Traversal******");
            System.out.println("1.Inorder Traversal\n2.Preorder Traversal\n3.Postorder Traversal\n4.Exit");
            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();

            switch (choice) 
			{
                case 1:
                    System.out.println("Inorder Traversal: ");
                    Traversal.Inorder();
                    break;

                case 2:
                    System.out.println("\nPreorder Traversal: ");
                    Traversal.Preorder();
                    break;

                case 3:
                    System.out.println("\nPostorder Traversal: ");
                    Traversal.Postorder();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
