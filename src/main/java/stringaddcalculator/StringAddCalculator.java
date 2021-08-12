package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Delimiters delimiters = new Delimiters();

    public static int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return 0;
        }

        TargetNumbers targetNumbers = TargetNumbers.from(checkCustomDelimiterAndGetSplitNumberString(inputString));

        return targetNumbers.sum();
    }

    private static String[] checkCustomDelimiterAndGetSplitNumberString(String inputString) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if(matcher.find()){
            delimiters.addDelimiter(matcher.group(1));
            return matcher.group(2).split(delimiters.regex());
        }

        return inputString.split(delimiters.regex());
    }

    private static boolean isNullOrEmpty(String inputString){
        return inputString == null || inputString.isEmpty() || inputString.trim().isEmpty();
    }
}
