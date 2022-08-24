package AbstractDataTypes;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public T find(T info) {
        if (this.isEmpty()) {
            return null;
        } else {
            return root.findNode(info);
        }
    }

    public void insert(T info) {
        if (this.isEmpty()) {
            this.root = new TreeNode<>(info);
        } else {
            root.insertNode(info);
        }
    }

    public void walkByLevel() {
        Queue<TreeNode> queue;
        TreeNode<T> auxiliaryNode;
        if (!this.isEmpty()) {
            queue = new Queue<>();
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                auxiliaryNode = queue.dequeue();
                if (auxiliaryNode.getLeft() != null) {
                    queue.enqueue(auxiliaryNode.getLeft());
                }
                if (auxiliaryNode.getRight() != null) {
                    queue.enqueue(auxiliaryNode.getRight());
                }
                System.out.println(auxiliaryNode.getInfo() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Empty tree.");
        }
    }

    public void inOrder() {
        if (this.isEmpty()) {
            System.out.println("Empty tree.");
        } else {
            walkOrdinated(root);
        }
    }

    private void walkOrdinated(TreeNode<T> root) {
        if (root != null) {
            walkOrdinated(root.getLeft());
            System.out.println(root.getInfo() + " ");
            walkOrdinated(root.getRight());
        }
    }

    private TreeNode<T> getAdressOfNodeWithLowestValue() {
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode.getLeft() != null) {
            auxiliaryNode = auxiliaryNode.getLeft();
        }
        return auxiliaryNode;
    }

    public T getLowestValue() {
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode.getLeft() != null) {
            auxiliaryNode = auxiliaryNode.getLeft();
        }
        return auxiliaryNode.getInfo();
    }

    private TreeNode<T> getAdressOfNodeWithHighestValue() {
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode.getRight() != null) {
            auxiliaryNode = auxiliaryNode.getLeft();
        }
        return auxiliaryNode;
    }

    public T getHighestValue() {
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode.getRight() != null) {
            auxiliaryNode = auxiliaryNode.getRight();
        }
        return auxiliaryNode.getInfo();
    }

    public int treeNodeCount(TreeNode<T> root) {
        int leftHeight;
        int rightHeight;
        int result;
        if (this.isEmpty()) {
            return 0;
        }
        leftHeight = treeLeftHeight();
        rightHeight = treeRightHeight();
        if (leftHeight == rightHeight) {
            result = (int) Math.pow(2, leftHeight + rightHeight);
            return result;
        }
        return 1 + treeNodeCount(root.getLeft()) + treeNodeCount(root.getRight());
    }

    private int treeLeftHeight() {
        int height = 0;
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode != null) {
            height++;
            auxiliaryNode = auxiliaryNode.getLeft();
        }
        return height;
    }

    private int treeRightHeight() {
        int height = 0;
        TreeNode<T> auxiliaryNode;
        auxiliaryNode = this.root;
        while (auxiliaryNode != null) {
            height++;
            auxiliaryNode = auxiliaryNode.getRight();
        }
        return height;
    }

}
