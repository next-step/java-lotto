package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        int result = 0;

        List<Object> splittedInput = toIntArray(input);
        for (int i = 1; i < splittedInput.size(); i = i+2) {
            result = compute(result, splittedInput, i);
        }
        return result;
    }

    private static int compute(int result, List<Object> splittedInput, int i) {
        if (i == 1) {
            result = runOperator((Integer) splittedInput.get(i -1), splittedInput.get(i).toString(), (Integer) splittedInput.get(i +1));
        }
        if (i > 1) {
            result = runOperator(result, splittedInput.get(i).toString(), (Integer) splittedInput.get(i +1));
        }
        return result;
    }

    private static int runOperator(int leftValue, String operator, int rightValue) {
        int result = 0 ;
        if (operator.equals("+")) {
            result = addNum(leftValue, rightValue);
        }
        if (operator.equals("-")) {
            result = subtractNum(leftValue, rightValue);
        }
        if (operator.equals("*")) {
            result = multiplyNum(leftValue, rightValue);
        }
        if (operator.equals("/")) {
            result = divideNum(leftValue, rightValue);
        }
        return result;
    }

    public static List<Object> toIntArray(String input) {
        String[] splittedString = input.split(" ");
        return processEachLetter(splittedString);
    }

    private static List<Object> processEachLetter(String[] spliitedString) {
        List<Object> result = new ArrayList<>();
        Arrays.stream(spliitedString).forEach(eachWord-> {
            try {
                int num = Integer.parseInt(eachWord);
                result.add(num);
            } catch (NumberFormatException nfe) {
                result.add(eachWord);
            }
        });
        return result;
    }

    public static int addNum(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    public static int subtractNum(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }

    public static int multiplyNum(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }

    public static int divideNum(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }
}
