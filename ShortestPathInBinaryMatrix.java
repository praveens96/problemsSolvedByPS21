/*
Leet code: https://leetcode.com/problems/shortest-path-in-binary-matrix/
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int r = grid.length; //rows
        int c = grid[0].length; //columns
        // if first/start or last/end is 1 return -1 as path wont be possible.
        if(grid[0][0] == 1 || grid[r-1][c-1] ==1){ 
            return -1;
        }
        // queue for adding elements
        Queue<int[]> queue = new LinkedList();
        // to keep track if a node is visited or not
        boolean[][] visited = new boolean[r][c];
        int count = 0; // no of steps required/answer 
        //add first/start to queue
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            //loop over the queue
            for(int i=0; i<size; i++){
                 // remove an element
                int[] poll = queue.poll();
                // check if thats the destination/end
                if(poll[0] == r-1 && poll[1] ==c-1){
                    return count + 1;
                }
                //explore neightbours i.e. add them to queue & mark as visited
                for(int[] dir: directions){
                    int x = dir[0] + poll[0];
                    int y = dir[1] + poll[1];
                    if(x < r && x >= 0 && y < c && y >= 0 && !visited[x][y] && grid[x][y] != 1){
                        queue.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            // increment path after the queue its all neightbours added explored
            count++;
        }
        
        return -1;
    }
}
