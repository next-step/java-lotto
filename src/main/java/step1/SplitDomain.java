package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDomain {

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
            String[] basicSplitInputNumber = inputNumbers.split(",");
            return changeType(basicSplitInputNumber);
        }

        return changeType(splitResult);
    }

    public int[] customizeSplitInputNumber(String inputNumbers) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputNumbers);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] customizeNumber = m.group(2).split(customDelimiter);
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
        }
        return inputNumbers;
    }

}
