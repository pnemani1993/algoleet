package com.algoleet.topic;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestTopicSolution {

    @Test
    public void testTwoSum1(){
        TopicSolution ts = new TopicSolution();
        int[] testNums = new int[]{3,4,2};
        int testTarget = 6;
        int[] answerArray = new int[]{1,2};
        assertArrayEquals(ts.twoSum(testNums, testTarget), answerArray);
    }

    @Test
    public void testTwoSum2(){
        TopicSolution ts = new TopicSolution();
        int[] testNums = new int[]{3,3};
        int testTarget = 6;
        int[] answerArray = new int[]{0,1};
        assertArrayEquals(ts.twoSum(testNums, testTarget), answerArray);
    }


}
