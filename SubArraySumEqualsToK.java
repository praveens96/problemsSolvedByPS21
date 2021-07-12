/**
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Refer: https://leetcode.com/problems/subarray-sum-equals-k/
KEY: If difference between sum up to that index matches target increment the count.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
    return count;
    }
}

/**
Test cases:
[1,1,1] 1
[1,2,3] 3
[-1,-1,1] 0
[1] 1
[1,2,3,4,5] 9

Space Complexity: o(n)
Time Complexity: o(n)
*/
