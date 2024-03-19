import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    char data;
    TreeNode left, right;

    TreeNode(char item) {
        data = item;
        left = right = null;
    }
}

public class ExpressionTree {

    static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    static TreeNode constructExpressionTreePostfix(String postfix) {
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                stack.push(new TreeNode(c));
            } else {
                TreeNode operand2 = stack.pop();
                TreeNode operand1 = stack.pop();

                TreeNode operatorNode = new TreeNode(c);
                operatorNode.left = operand1;
                operatorNode.right = operand2;

                stack.push(operatorNode);
            }
        }
        return stack.pop();
    }

    static void recursiveInOrderTraversal(TreeNode root) {
        if (root != null) {
            recursiveInOrderTraversal(root.left);
            System.out.print(root.data + " ");
            recursiveInOrderTraversal(root.right);
        }
    }

    static void recursivePreOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            recursivePreOrderTraversal(root.left);
            recursivePreOrderTraversal(root.right);
        }
    }

    static void recursivePostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursivePostOrderTraversal(root.left);
            recursivePostOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the postfix expression: ");
        String postfixExpression = scanner.next();

        TreeNode root = constructExpressionTreePostfix(postfixExpression);

        System.out.print("Recursive In-Order Traversal: ");
        recursiveInOrderTraversal(root);
        System.out.println();

        System.out.print("Recursive Pre-Order Traversal: ");
        recursivePreOrderTraversal(root);
        System.out.println();

        System.out.print("Recursive Post-Order Traversal: ");
        recursivePostOrderTraversal(root);
        System.out.println();

        scanner.close();
    }
}
