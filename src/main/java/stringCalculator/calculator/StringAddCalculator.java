package stringCalculator.calculator;

import stringCalculator.common.Constant;
import stringCalculator.number.Positive;
import stringCalculator.utility.PatternChecker;
import stringCalculator.utility.Separator;
import stringCalculator.utility.Validator;

public class StringAddCalculator {
    private final Separator separator;

    public StringAddCalculator() {
        separator = new Separator();
    }

    public int splitAndSum(String input) {
        if (!Validator.isValidInput(input)) {
            return 0;
        }
        PatternChecker patternChecker = new PatternChecker(input);
        String delimiter = Constant.DEFAULT_DELIMITER;
        if (patternChecker.isCustomDelimiter()) {
            input = patternChecker.getText();
            delimiter = patternChecker.getDelimiter();
        }
        return sumPositive(separator.splitNumber(input, delimiter));
    }

    private int sumPositive(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            Positive positive = new Positive(number);
            result += positive.getValue();
        }
        return result;
    }
}