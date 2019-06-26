package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDomain {

    public String[] checkSplitInputNumber(String inputNumbers) {
        if (!inputNumbers.contains(",") && !inputNumbers.contains(":")) {
            return customizeSplitInputNumber(inputNumbers);
        }
        return splitTokensNumber(inputNumbers);
    }

    public String[] splitTokensNumber(String inputNumbers) {
        if (inputNumbers.contains(",") && inputNumbers.contains(":")) {
            String[] splitTokensNumber = inputNumbers.split(",|:");
            return splitTokensNumber;
        }
        return basicSplitInputNumber(inputNumbers);
    }

    private String[] basicSplitInputNumber(String inputNumbers) {
        String[] splitResult = {inputNumbers};
        if (inputNumbers.contains(",")) {
            String[] basicSplitInputNumber = inputNumbers.split(",");
            return basicSplitInputNumber;
        }
        if (inputNumbers.contains(":")) {
            String[] basicSplitInputNumber = inputNumbers.split(",");
            return basicSplitInputNumber;
        }

        return splitResult;
    }

    public String[] customizeSplitInputNumber(String inputNumbers) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputNumbers);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] customizeNumber = m.group(2).split(customDelimiter);
            return customizeNumber;
        }
        return onlyOneInputNumber(inputNumbers);
    }

    public String[] onlyOneInputNumber(String inputNumbers) {
        String[] onlyOneInputNumber = {inputNumbers};
        return onlyOneInputNumber;
    }


}
