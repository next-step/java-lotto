package step1.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int splitAndSum(String inputString) {
        if (checkNullinput(inputString)) {
            return 0;
        }
        String[] splitString = makeSplitString(inputString);
        return sumNumbers(splitString);
    }

    private static boolean checkMinus(int num) {

        if (num < 0) {
            throw new RuntimeException("양수를 넣어주세");
        }

        return true;
    }

    private static int convrrtStringToint(String stringNum) {
        int number = 0;

        try {
            number = Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }

        return number;
    }

    private static int add(int sum, int convertNum) {
        return checkMinus(convertNum) ? sum + convertNum : sum;
    }

    private static int sumNumbers(String[] splitString) {
        int sum = 0;
        for (String num : splitString) {
            int convertNum = convrrtStringToint(num);
            sum = add(sum, convertNum);
        }

        return sum;
    }

    private static String[] makeSplitString(String inputString) {
        String[] splitString = null;
        Matcher m = pattern.matcher(inputString);
        if (m.find()) {
            DELIMITER = m.group(1);
            splitString = m.group(2).split(DELIMITER);

            return splitString;
        }

        return inputString.split(DELIMITER);
    }

    public static boolean checkNullinput(String inputString) {
        return inputString == null || inputString.isEmpty();
    }
}