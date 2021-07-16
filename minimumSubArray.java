/*
  This will when repeating charaters are there in pattern
  Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

**/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] ascii_str = new int[256];
        int[] ascii_pat = new int[256];
        int count = 0;
        int start = 0;
        int wl = 0;
        for(int i=0; i < 256; i++){
            ascii_str[i] = 0;
            ascii_pat[i] = 0;
        }
        
        for(int i=0;i<t.length();i++){
            ascii_pat[t.charAt(i)] = 1;
        }
        
        for(int i=0; i < s.length(); i++){
            ascii_str[s.charAt(i)]++;
            wl++;
            if (ascii_pat[s.charAt(i)] == 1 && ascii_str[s.charAt(i)] <= 1) {
                count++;
            }
            //System.out.println("ascii_str:"+Arrays.toString(ascii_pat)+","+ascii_pat[s.charAt(start)]);
            if(count == t.length() && wl == t.length()){
                break;
            }
            // if(count == t.length()){ //&& ascii_str[s.charAt(i)] > 1
                
                //all are accommodated, apply 2 rules - no repeat, 2. should be in path
                while(start >= 0 && wl > 0 && start <= s.length() &&(ascii_str[s.charAt(start)] > 1 || ascii_pat[s.charAt(start)] == 0)){
                    System.out.println("correcting:"+wl+","+start+","+s.charAt(start)+",");        
                    ascii_str[s.charAt(start)]--;
                    System.out.println("after");
                    start++;
                    wl--;
                   // System.out.println("correcting2:"+wl+","+start+","+s.charAt(start)+","); 
                }
            
            // }
        }
        if(count == 0){
            return "";
        }
        //remove last
        for(int i=start+wl-1;i>start;i--){
            if(ascii_pat[s.charAt(i)] == 0){
                wl--;
            } else {
                break;
            }
        }
        System.out.println("start:"+start+","+count);
        System.out.println("wl:"+wl);
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<start+wl;i++){
            sb.append(s.charAt(i));
        }
        System.out.println("sb:"+sb.toString());
        return sb.toString();
    }
}

/**
Testcases:
aa a, 
aa b,
a b,
bb a,
aqcdoabanc abc
Ref: https://www.youtube.com/watch?v=XbsJUVbMnM4

*/
