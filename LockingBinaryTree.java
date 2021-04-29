

/******************************************************************************
This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

*******************************************************************************/

public class Main
{
    
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}

class LockingBinaryTree {
    
    private class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        boolean locked;
        int descendantLockCount;
    }
    Node root;
    boolean isLocked(Node n){
        return n.locked;
    }
    boolean lock(Node n) {
        // if all descendants and ancestors are not locked only we can lock
        if(n.locked == true){
            return true;
        }
        if(n.descendantLockCount > 0){
            return false;
        }
        if(n.parent == null){
            // root node
            return true;
        } else {
            if(!canLockOrUnlock(n)) {
                return false;
            } else {
                n.locked = true;
                //increment
                incrementLockCount(n.parent);
                return true;
            }
        }
        
    }
    boolean canLockOrUnlock(Node n) {
        Node current = n.parent;
            while(current.parent != null){
                if(current.descendantLockCount > 0){
                    // break;
                    return false;
                }
                current = current.parent;
            }
            return true;
    }
    void incrementLockCount(Node p){
        while(p.parent != null){
            p.descendantLockCount += 1;
            p = p.parent;
        }
    }
    void decrementLockCount(Node p){
        while(p.parent != null){
            p.descendantLockCount -= 1;
            p = p.parent;
        }
    }
    boolean unlock(Node n) {
        if(!canLockOrUnlock(n)) {
            return false;
        } else {
        n.locked = false;
        //decrement count
        decrementLockCount(n);
        return true;
        }
    }
    
}

/**


/******************************************************************************
This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

*******************************************************************************/

public class Main
{
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		Node lbt = new Node(1);
		lbt.parent = null;
		lbt.left = new Node(2);
		lbt.left.parent = lbt;
		lbt.right = new Node(3);
		lbt.right.parent = lbt;
		lbt.left.left = new Node(4);
		lbt.left.right = new Node(5);
		lbt.left.parent = lbt.left;
		lbt.right.left = new Node(6);
		lbt.right.right = new Node(7);
		lbt.right.parent = lbt.right;
		boolean haslocked1 = lbt.left.lock();
		System.out.println(haslocked1);
// 		Node 
	}
}

// class LockingBinaryTree {
//     Node root;
//     public LockingBinaryTree(int val, boolean locked) {
//         Node newNode = new Node(val, locked);
//         newNode.parent = null;
//         newNode.left = null;
//         newNode.right = null;
//     }
    class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        boolean locked = false;
        int descendantLockCount = 0;
        public Node(int val) {
            // Node newNode = new Node();
            this.data = val;
            this.descendantLockCount = 0;
        }
    
    
    boolean isLocked(Node n){
        return n.locked;
    }
    boolean lock(Node n) {
        // if all descendants and ancestors are not locked only we can lock
        if(n.locked == true){
            return true;
        }
        if(n.descendantLockCount > 0){
            return false;
        }
        if(n.parent == null){
            // root node
            return true;
        } else {
            if(!canLockOrUnlock(n)) {
                return false;
            } else {
                n.locked = true;
                //increment
                incrementLockCount(n.parent);
                return true;
            }
        }
        
    }
    boolean canLockOrUnlock(Node n) {
        Node current = n.parent;
            while(current.parent != null){
                if(current.descendantLockCount > 0){
                    // break;
                    return false;
                }
                current = current.parent;
            }
            return true;
    }
    void incrementLockCount(Node p){
        while(p.parent != null){
            p.descendantLockCount += 1;
            p = p.parent;
        }
    }
    void decrementLockCount(Node p){
        while(p.parent != null){
            p.descendantLockCount -= 1;
            p = p.parent;
        }
    }
    boolean unlock(Node n) {
        if(!canLockOrUnlock(n)) {
            return false;
        } else {
        n.locked = false;
        //decrement count
        decrementLockCount(n);
        return true;
        }
    }
    
}
*/
