package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String CUSTOM_PATTERN = "//(.)\\n(.*)";


    public static int splitAndSum(String input) {
        if (isEmpty(input)){
            return 0;
        }

        if (input.matches(NUMBER_PATTERN)){
            return Integer.parseInt(input);
        }

        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (m.find()){
            String customDelimiter = m.group(1);
            String[] stringNumbers = m.group(2).split(customDelimiter);
            return stringSum(stringNumbers);
        }

        if (input.contains(",") || input.contains(";")){
            String[] stringNumbers = input.split(",|:");
            return stringSum(stringNumbers);
        }

        throw new RuntimeException();
    }

    private static boolean isEmpty(String input) {
        if (input == null || input == ""){
            return true;
        }
        return false;
    }

    private static int stringSum(String[] stringNumbers) {
        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int num = Integer.parseInt(stringNumber);
            negativeCheck(num);
            sum += num;
        }
        return sum;
    }

    private static void negativeCheck(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

}
