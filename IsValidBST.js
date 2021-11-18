/**
given an array in order, find its valid bst or not.
* Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 https://leetcode.com/problems/validate-binary-search-tree/
*/
var isValidBST = function(root) {
    return helper(root, -Infinity, +Infinity)
};

function helper (node, min, max){
    console.log('node, min, max::', node, min, max, !node);
    if(!node){
        return true;
    }
    if( node.val <= min ||  node.val >= max){
        return false;   
    }
    return helper(node.left, min, node.val) && helper(node.right, node.val, max);
}

/**
Only Infinity works. Number.MIN_NUMBER, Number.MAX_NUMBER OR Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER work.
testcases:
[0]
[1,1]
[2,1,3]
[5,1,4,null,null,3,6]
*/
