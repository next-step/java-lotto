package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDomain {

    private ValidationCheck validationCheck = new ValidationCheck();
    private static final String CUSTOM_SPLIT = "//(.)\n(.*)";
    private static final int CUSTOM_FIRST_GROUP = 1;
    private static final int CUSTOM_SECOND_GROUP = 2;


    public int[] checkSplitInputNumber(String inputNumbers) {
        if (!inputNumbers.contains(",") && !inputNumbers.contains(":")) {
            return customizeSplitInputNumber(inputNumbers);
        }
        return splitTokensNumber(inputNumbers);
    }

    public int[] splitTokensNumber(String inputNumbers) {
        if (inputNumbers.contains(",") && inputNumbers.contains(":")) {
            String[] splitTokensNumber = inputNumbers.split(",|:");
            return changeType(splitTokensNumber);
        }
        return basicSplitInputNumber(inputNumbers);
    }

    public int[] basicSplitInputNumber(String inputNumbers) {
        String[] splitResult = {inputNumbers};
        if (inputNumbers.contains(",")) {
            String[] basicSplitInputNumber = inputNumbers.split(",");
            return changeType(basicSplitInputNumber);
        }
        if (inputNumbers.contains(":")) {
            String[] basicSplitInputNumber = inputNumbers.split(":");
            return changeType(basicSplitInputNumber);
        }

        return changeType(splitResult);
    }

    public int[] customizeSplitInputNumber(String inputNumbers) {
        Matcher m = Pattern.compile(CUSTOM_SPLIT).matcher(inputNumbers);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_FIRST_GROUP);
            String[] customizeNumber = m.group(CUSTOM_SECOND_GROUP).split(customDelimiter);
            return changeType(customizeNumber);
        }
        return onlyOneInputNumber(inputNumbers);
    }

    public int[] onlyOneInputNumber(String inputNumbers) {
        String[] onlyOneInputNumber = {inputNumbers};
        return changeType(onlyOneInputNumber);
    }

    private int[] changeType(String[] splitNumber) {
        int[] inputNumbers = new int[splitNumber.length];

        for (int index = 0; index < splitNumber.length; index++) {
            inputNumbers[index] = Integer.parseInt(splitNumber[index]);
            validationCheck.checkNegative(inputNumbers[index]);
        }

        return inputNumbers;
    }

}
