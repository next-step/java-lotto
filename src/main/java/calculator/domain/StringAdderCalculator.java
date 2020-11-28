package calculator.domain;

import calculator.utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdderCalculator {
    private static final String customRegex = "//(.)\n(.*)";
    private static final String defaultRegex = ",|:";

    private static final Pattern USER_DEFINE_DELIMITER = Pattern.compile(customRegex);

    private CalculatorOperand resultOfOperation;
    private List<CalculatorOperand> calculatorOperands;

    public StringAdderCalculator() {
        calculatorOperands = new ArrayList<>();
        resultOfOperation = new CalculatorOperand("0");
    }

    public int sum(String userInput) {
        if (Util.isNullOrEmpty(userInput)) {
            return this.resultOfOperation.getOperand();
        }

        parseOperands(this.splitOperands(userInput));
        sumOperands();
        return this.resultOfOperation.getOperand();
    }

    private void parseOperands(String[] operands) {
        for (String operand : operands) {
            this.calculatorOperands.add(new CalculatorOperand(operand));
        }
    }

    private String[] splitOperands(String userInput) {
        Matcher customMatcher = USER_DEFINE_DELIMITER.matcher(userInput);
        if (customMatcher.find()) {
            String customDelimiter = customMatcher.group(1);
             return customMatcher.group(2).split(customDelimiter);
        }

        return userInput.trim().split(defaultRegex);
    }

    private void sumOperands() {
        for (CalculatorOperand calculatorOperand : this.calculatorOperands) {
            this.resultOfOperation.sum(calculatorOperand);
        }
    }
}
