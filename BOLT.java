/**
This news headline has been echoing in Chef's mind since 2009 when he started his career in sprinting. This time in the 2021 Tokyo Olympics he is determined to make a new world record.

There are mainly 3 important factors that result in the variation in speed during practice and during competition.

The first factor is a difference in track material which results in variation in the speed at competition with respect to practice by a factor of k1.

The second factor is wind speed which results in variation in the speed at competition with respect to practice by a factor of k2.

The final factor is the maximum speed achieved during practice. If the maximum speed during practice is v m/s then in competition it will be k3∗v m/s.

Given Chef's max speed v during practice and the factors k1,k2,k3, find whether he will be able to create a new world record, i.e, can he complete 100 m in less than 9.58 seconds?

Note: The final time displayed by the Olympics clock is showing after rounding the original time to 2 places of decimal and is the only measure of runners performance.
*/
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
  
        // Reading data using readLine
        String strNoOfTestcases = reader.readLine();
        int noOfTestcases = Integer.parseInt(strNoOfTestcases);
        // Printing the read line
        // System.out.println(noOfTestcases);
        float worldRecordTime = (float)9.58;
        String testInputs="";
        String []inVals = {};
        float []inFloats = {};
        float time = (float)0.0;
        for(int i=0; i<noOfTestcases; i++){
            testInputs = reader.readLine();
            // System.out.println(testInputs);
            if(testInputs !=null){
                inVals = testInputs.split(" ");    
                // System.out.println("inVals"+String.join(",", inVals));
                // get float array
                inFloats = getFloatArray(inVals);
                // System.out.println("inFloats"+String.join(",", inFloats));
                if(inFloats != null && inFloats.length == inVals.length){
                    // do math
                    time = calcTime(inFloats);
                    if(Float.compare(time, worldRecordTime) < 0){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
            
        }
	}
	
	static float[] getFloatArray(String []inputs){
	    float []vals = {};
	    if(inputs !=null){
	        vals = new float[inputs.length];
	        for(int n=0;n<inputs.length;n++){
	            if(inputs[n] != null)
	                vals[n] = Float.parseFloat(inputs[n]);
	            else
	                break;
	        }
	       // return vals;
	    }
	    return vals;
	}
	
	static float calcTime(float []params){
	    float speed=(float)1.0;
	    for(int i=0;i<params.length;i++){
	        speed *= params[i];
	    }
	   // System.out.println(speed);
	    float time = 100/speed;
	   // System.out.println((float)(Math.round(time * 100.0) / 100.0));
	    return (float)(Math.round(time * 100.0) / 100.0);
	}
}
