/**
 * This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. 
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * Ref: https://leetcode.com/discuss/interview-question/299086/amazon-phone-screen-run-length-encoding
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) throws IOException{
		// run length encoding
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in = reader.readLine();
		String encoded = encode(in);
		System.out.println(encoded);
		String decoded = decode(encoded);
		System.out.println(decoded);
    }
    
    public static String encode(String in) {
        StringBuilder out = new StringBuilder();
		int count = 1;
		char c = in.charAt(0);
		if(in.length()==1){
		    System.out.println(1+""+c);
		    return "";
		}
		for(int i=0; i<=in.length()-2; i++){
			if(c == in.charAt(i+1)){
			    count++;
			} else {
			    out.append(count+""+c);
			    count = 1;
			}
			c = in.charAt(i+1);
		}
		if(in.charAt(in.length()-1)==in.charAt(in.length()-2)){
		    out.append(count+""+c);
		} else {
		    out.append(1+""+in.charAt(in.length()-1));
		}
		return out.toString();
    }
    
    public static String decode(String in) {
        //3A4B1D
        StringBuilder sb = new StringBuilder();
        // System.out.println(in.charAt(0));
        char ch = '\0';
        int n = 0;
        for(int i=0;i<in.length();i++){
            ch = in.charAt(i);
            n=0;
            while(Character.isDigit(ch)){
                n = (n*10) + Character.digit(ch, 10);
                ch = in.charAt(++i);
            }
            sb.append(String.valueOf(ch).repeat(n));
        }
        return sb.toString();
    }
}

/**
 * Testcases: 
 * A
 * AA
 * AB
 * ABDD
 * AAABBCCDDD
*/
