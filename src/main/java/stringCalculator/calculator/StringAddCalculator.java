package stringCalculator.calculator;

import stringCalculator.number.Positive;
import stringCalculator.utility.PatternChecker;
import stringCalculator.utility.Separator;
import stringCalculator.utility.Validator;

public class StringAddCalculator {
    private final Separator separator;
    private final PatternChecker patternChecker;

    public StringAddCalculator() {
        separator = new Separator();
        patternChecker = new PatternChecker();
    }

    public int splitAndSum(String input) {
        if (!Validator.isValidInput(input)) {
            return 0;
        }
        patternChecker.setTextAndDelimiter(input);
        String text = patternChecker.getText();
        String delimiter = patternChecker.getDelimiter();
        return sumPositive(separator.splitNumber(text, delimiter));
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