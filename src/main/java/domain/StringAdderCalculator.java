package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdderCalculator {
    private CalculatorOperand resultOfOperation;
    private List<CalculatorOperand> calculatorOperands;

    public StringAdderCalculator() {
        calculatorOperands = new ArrayList<>();
        resultOfOperation = new CalculatorOperand("0");
    }

    public int sum(String userInput) {
        if (this.isNullOrEmpty(userInput)) {
            return this.resultOfOperation.getOperand();
        }

        parseOperands(this.splitOperands(userInput));
        sumOperands();
        return this.resultOfOperation.getOperand();
    }

    private void sumOperands() {
        for (CalculatorOperand calculatorOperand : this.calculatorOperands) {
            this.resultOfOperation.sum(calculatorOperand);
        }
    }

    private void parseOperands(String[] operands) {
        for (String operand : operands) {
            this.calculatorOperands.add(new CalculatorOperand(operand));
        }
    }

    private String[] splitOperands(String userInput) {
        final String customRegex = "//(.)\n(.*)";
        final String defaultRegex = ",|:";

        Matcher customMatcher = Pattern.compile(customRegex).matcher(userInput);
        if (customMatcher.find()) {
            String customDelimiter = customMatcher.group(1);
             return customMatcher.group(2).split(customDelimiter);
        }

        return userInput.trim().split(defaultRegex);
    }

    private static boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }

}
