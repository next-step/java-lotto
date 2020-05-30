package modal;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    public static int splitAndSum(String inputString) {
        if(checkNullinput(inputString)) {
            return 0;
        }
        String[] splitString = makeSplitString(inputString);
        return sumNumbers(splitString);
    }

    private static int checkMinus(String stringNum) {
        int number = 0;
        try {
            number = Integer.parseInt(stringNum);
            if(number < 0) {
                throw new RuntimeException();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        return number;
    }

    private static int sumNumbers(String[] splitString) {
        int sum = 0;
        for( String num :  splitString) {
            sum += checkMinus(num);
        }

        return sum;
    }

    private static String[] makeSplitString(String inputString) {
        String[] splitString = null;
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(inputString);
        if(m.find()) {
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
