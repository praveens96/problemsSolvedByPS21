/**
  Problem: https://leetcode.com/problems/sort-the-matrix-diagonally/
  Ref: https://www.youtube.com/watch?v=JBqUl7avtG8
*/
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n= mat[0].length;
        
         for(int i=0;i<n;i++){
            sort(mat,0,i,m,n);
        }
        
        for(int i=1;i<m;i++){
            sort(mat,i,0,m,n);            
        }
        return mat;
    }
    /**
      Sorting can either use inbuilt Collections.sort or counting sort.
      Here counting sort is helpful as the max number is 101 for matrix values
    */
    void sort(int[][] mat, int row, int col, int rows, int cols){
        // List<Integer> values = new ArrayList();
        int[] values=new int[101];
        int r= row;
        int c= col;
      // incrementing resprctive values of matrix index
        while(r<rows && c<cols){
            // values.add(mat[r][c]);
            values[mat[r][c]]++;
            r++;
            c++;
        }
        // Collections.sort(values);
        r=row;
        c=col;
      // loop over the array of values and get them, as the loop is order, o/p will be sorted. complexity o(n)
        for(int i=0;i<101;i++){
            int count = values[i];
            if(count>0){
                while(count-- > 0){
                    mat[r][c] = i;
                    r++;
                    c++;
                }
            }
        }
        // int index=0;
        // while(r<rows && c<cols){
        //     mat[r][c] = values.get(index++);
        //     r++;
        //     c++;
        // }
        // System.out.println(Arrays.deepToString(mat));
        // return mat;
    }
}

/**
  Testcases: 
  [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
*/
