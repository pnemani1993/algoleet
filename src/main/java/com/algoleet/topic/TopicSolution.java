package com.algoleet.topic;

import java.util.HashMap;
import java.util.Map;

public class TopicSolution {

    /**
     * #1. Two Sum - https://leetcode.com/problems/two-sum/
     * @param int[] nums
     * @param int target
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) return new int[]{0,1};
        int[] returnArray = new int[2];
        Map<Integer, Integer> mapping = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mapping.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++ ){
            int diff = target - nums[i];
            if(mapping.containsKey(diff) && mapping.get(diff) != i){
                returnArray[0] = i;
                returnArray[1] = mapping.get(diff);
                return returnArray;
            }
        }
        return returnArray;
    }

    /**
     * #2. Add Two Numbers - https://leetcode.com/problems/add-two-numbers/
     * @param ListNode l1
     * @param ListNode l2
     * @return ListNode root
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode rootNode = new ListNode((current1.val + current2.val)%10);
        ListNode currentNode = rootNode;
        int carry = (current1.val + current2.val)/10;
        current1 = current1.next;
        current2 = current2.next;
        ListNode currentR = null;
        while(current1 != null && current2 != null){
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = (current1.val + current2.val + carry)%10;
            carry = (current1.val + current2.val + carry)/10;
            current1 = current1.next;
            current2 = current2.next;
        }

        if(current1 == null && current2 == null && carry != 0){
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = carry;
            return rootNode;
        } else if(current1 == null && current2 == null && carry == 0) {
            return rootNode;
        }

        if(current1 == null) currentR = current2;
        else currentR = current1;

        while(currentR != null){
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = (currentR.val + carry)%10;
            carry = (currentR.val + carry)/10;
            currentR = currentR.next;
        }
        if(carry != 0){
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = carry;
        }
        
        return rootNode;
    }




    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    }

}
