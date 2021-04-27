/*
*This problem was asked by Facebook.
*
*Implement regular expression matching with the following special characters:
*
* . (period) which matches any single character
* * (asterisk) which matches zero or more of the preceding element
*That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
*
*For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return *false.
*
*Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
*/


class Solution {
    public boolean isMatch(String s, String p) {
        // this is solved by filling a matrix with the match b/w strin and pattern
        int m = s.length();
        int n = p.length();
        boolean[][] rm = new boolean[m+1][n+1]; //rm - regexMatrix
        rm[0][0] = true; // empty strings match
        for(int i=1;i<n+1;i++){
            if(p.charAt(i-1) == '*'){
                rm[0][i] = rm[0][i-2];
            }
        }
        // char could be * or . or alphabet
        // if char . , copy diagonal element in matrix because, if it matches till last char its a match
        // if char is * then, either the prev char is part of string or not.
        //  so, value will be either two values back in the row if prev char not included or 
        //     if included will be top col value (case of ?)
        // length + 1 is for accommodating the intial row n columns
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)){
                    rm[i][j] = rm[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    // rm[i][j-2] || rm[i-1][j])
                    rm[i][j] = rm[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                        rm[i][j] = rm[i][j] | rm[i-1][j];
                    }
                }
            }            
        }
        // System.out.println(Arrays.deepToString(rm));
        return rm[m][n];

    }
}
/*
*Testcases:
* aa, a*
* xaabyc, xa*b.c
* aa, a
* xabbyc, xa.*b.c
*/
