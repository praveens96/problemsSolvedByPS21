/******************************************************************************

This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*******************************************************************************/
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws java.lang.Exception {
		// no of meeting rooms required
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strNoofIntervals = reader.readLine();
		int noOfIntervals = Integer.parseInt(strNoofIntervals);
		long[][] intervals = new long[noOfIntervals][noOfIntervals];
		for(int i=0;i<noOfIntervals;i++){
		    String oneInLine = reader.readLine();
		    String[] inLineSplitted = oneInLine.split(" ");
		    intervals[i][0] = (long)Double.parseDouble(inLineSplitted[0]);
		    intervals[i][1] = (long)Double.parseDouble(inLineSplitted[1]);
		}
		meetingRoomsRequired(intervals);
		
	}
	static void meetingRoomsRequired(long[][] intervals){
	    Arrays.sort(intervals,Comparator.comparing((long[] interval) -> interval[0]));
	    PriorityQueue<Long> heap = new PriorityQueue<>();
	    int noOfMeetingRooms = 0;
	    for(int i=0;i<intervals.length;i++){
	        if(heap.isEmpty()){
	            noOfMeetingRooms++;
	            heap.offer(intervals[i][1]);
	        } else {
	            if(intervals[i][1]<heap.peek()){
	                noOfMeetingRooms++;
	            } else {
	                heap.poll();
	            }
	        }
	    }
	    System.out.println("Number of Rooms required:" + noOfMeetingRooms);
	}
}
