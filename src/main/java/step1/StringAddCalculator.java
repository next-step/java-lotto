package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String express) {
        if(express == null || "".equals(express)){
            return 0;
        }
        return calculate(express);
    }

    private static int calculate(String express) {
        try{
            return Integer.valueOf(express);
        }catch(NumberFormatException ex){
            return calculateString(express);
        }
    }

    private static int calculateString(String express) {
        String[] numbers = splitString(express);
        int result = 0;
        for(String number : numbers){
            result = addNumber(result, number);
        }
        return result;
    }

    private static String[] splitString(String express){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(express);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return express.split(",|:");
    }

    private static int addNumber(int result, String number) {
        if(!validation(number)){
            throw new RuntimeException("에러");
        }
        result += Integer.valueOf(number);
        return result;
    }

    private static boolean validation(String number) {
        int num = 0;
        try{
            num = Integer.valueOf(number);
            if(num < 0){
                return false;
            }
        }catch(NumberFormatException ex){
            return false;
        }
        return true;
    }
}
