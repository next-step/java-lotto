package calculator;

import util.NumberUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static int HAS_ONE_NUMBER = 1;
    public static int splitAndSum(String express) {
        if(isEmpty(express)) {
            return 0;
        };
        String[] splitNumbers = splitExpression(express);
        int result = sumNumbers(express, splitNumbers);
        return result;
    }

    private static int sumNumbers(String express, String[] split) {
        int result = 0;
        if(split.length == HAS_ONE_NUMBER) {
            return NumberUtil.stringToInt(express);
        }
        if(split.length > HAS_ONE_NUMBER){
            for ( int i = 0; i < split.length; i++) {
                String numberOfExpression = split[i];
                result = result + NumberUtil.stringToInt(numberOfExpression);
            }
        }
        return result;
    }

    private static String[] splitExpression(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return expression.split(",|:");
    }

    private static boolean isEmpty(String express) {
        if(express == null) {
            return true;
        }
        if(express.isEmpty()) {
            return true;
        }
        return false;
    }
}
