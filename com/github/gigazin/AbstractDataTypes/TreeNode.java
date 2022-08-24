package AbstractDataTypes;

class TreeNode<T extends Comparable<T>> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T info;

    TreeNode(T info) {
        this.info = info;
    }

    TreeNode<T> getRight() {
        return this.right;
    }

    void setRight(T newRight) {
        this.info = newRight;
    }

    TreeNode<T> getLeft() {
        return this.left;
    }

    void setLeft(T newLeft) {
        this.info = newLeft;
    }

    T getInfo() {
        return this.info;
    }

    void setInfo(T newInfo) {
        this.info = newInfo;
    }

    T findNode(T info) {
        if (info.compareTo(this.info) == 0) {
            return this.info;
        } else if (info.compareTo(this.info) < 0) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.findNode(info);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.findNode(info);
            }
        }
    }

    void insertNode(T info) {
        if (info.compareTo(this.getInfo()) == 0) {
            System.out.println("Repeated value.");
        } else if (info.compareTo(this.getInfo()) < 0) {
            if (this.left == null) {
                this.left = new TreeNode<>(info);
            } else {
                this.left.insertNode(info);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode<>(info);
            } else {
                this.right.insertNode(info);
            }
        }
    }

}
