package misc.BTreeToDLL;

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        /**
         *              1
         *       2          3
         *    4     5     6   7
         *
         *    4 2 5 1 6 3 7
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(printInOrder(root));

        TreeNode head = convertToDll(root);
        TreeNode rightMost = printDllLeft(head);
        printDllRight(rightMost);
    }

    private static void printDllRight(TreeNode n){
        StringBuilder s = new StringBuilder();
        while (n != null){
            s.append(" ");
            s.append(n.data);
            n = n.left;
        }
        System.out.println("Right to Left :" + s);
    }

    private static TreeNode printDllLeft(TreeNode node){
        StringBuilder s = new StringBuilder();
        while(node.right != null){
            s.append(node.data);
            s.append(" ");
            node = node.right;
        }
        s.append(node.data);
        System.out.println("Left to right is : " + s);
        return node;
    }

    private static TreeNode convertToDll(TreeNode root){
        convert(root);
        return getLeftMost(root);
    }

    private static void convert(TreeNode n){
        if(n == null){
            return;
        }

        convert(n.left);
        convert(n.right);
        TreeNode rightMost = getRightMost(n.left);
        TreeNode leftMost = getLeftMost(n.right);
        n.left = rightMost;
        if(rightMost != null){
            rightMost.right = n;
        }
        n.right = leftMost;
        if(leftMost != null){
            leftMost.left = n;
        }
    }

    private static TreeNode getLeftMost(TreeNode n){
        while(n != null && n.left != null){
            n = n.left;
        }
        return n;
    }

    private static TreeNode getRightMost(TreeNode n){
        while(n != null && n.right != null){
            n = n.right;
        }
        return n;
    }

    private static String printInOrder(TreeNode n){
        if(n == null){
            return "";
        }
        String l = printInOrder(n.left);
        String r = printInOrder(n.right);
        return "" + l + " " + n.data + " " + r;
    }
}
