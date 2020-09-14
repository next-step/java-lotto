package step2.controller;

import step2.util.Cast;

import java.util.List;

public class FindMatchNumber {
    public static int find(List number, String winningNumber) {
       int[] winningNum = Cast.castToNumber(winningNumber);
       return matchNumberCount(number, winningNum);
    }

    public static int matchNumberCount(List number, int[] winningNum) {
        int count = 0;
        for(int no : winningNum) {
            count = number.contains(no) ? count +1 : count;
        }
        return count;
    }

}
