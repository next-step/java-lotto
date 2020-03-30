package step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;

public class StringAddCalculator {
    private static final String PATTERN_END = "\n";
    private static final String PATTERN_START = "//";
    private static final int ZERO = 0;
    private static final Pattern pattern = Pattern.compile(PATTERN_START + "(.)" + PATTERN_END + "(.*)");
    private static String CUSTOM_DELIMITER = "[,:]";

    public static int splitAndSum(String inputData) {
        String[] splitInputData;
        if (checkNullInputData(inputData)) {
            return 0;
        }
        inputData = makeMatcher(inputData);
        splitInputData = inputData.split(CUSTOM_DELIMITER);
        return sumFromSplitInputData(splitInputData);
    }

    private static String makeMatcher(String inputData) {
        Matcher matcher = pattern.matcher(inputData);
        if (matcher.find()) {
            CUSTOM_DELIMITER = matcher.group(1);
            inputData = matcher.group(2);
        }
        return inputData;
    }

    private static int sumFromSplitInputData(String[] splitInputData) {
        int result = ZERO;
        for (String splitData : splitInputData) {
            result = result + checkMinus(splitData);
        }
        return result;
    }

    private static int checkMinus(String splitInputData) {
        int splitData = ZERO;
        try{
            splitData = Integer.parseInt(splitInputData);
            if (splitData < 0) {
                throw new RuntimeException();
            }
        }catch(NumberFormatException e){
            throw new NumberFormatException();
        }
        return splitData;
    }

    private static boolean checkNullInputData(String inputData) {
        return inputData == null || inputData.isEmpty();
    }
}
