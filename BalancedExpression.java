/**
This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.

*/
import java.io.*;
import java.util.*;

public class MyClass {
    public static void main(String args[]) throws IOException {
      // expression evaluation ([])[]({})
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String in = reader.readLine();
      Stack st = new Stack();
      String o = "([{";
      String c = ")]}";
      Map<Character, Character> matches = new HashMap();
      matches.put(')','(');
      matches.put(']','[');
      matches.put('}','{');
      char ch = '\0';
      boolean output = false;
      for(int i=0; i < in.length(); i++){
          ch = in.charAt(i);
          if(o.indexOf(ch) >= 0){
              st.push(ch);
              continue;
          }
          //
          if(st.isEmpty()){
            output = false;
              break;
          }
          if(st.peek() != null && matches.get(ch) == null || st.peek() != matches.get(ch)){
            //   System.out.println("invalid2");
            output = false;
              break;
          } else {
              output = true;
              st.pop();
          }
      }
      if(st.isEmpty() && output != false){
          System.out.println("valid");
      } else {
          System.out.println("invalid");
      }
    }
}

/**
Testcases:
([])[]({})
(
}
()
()}
([{]})
*/
