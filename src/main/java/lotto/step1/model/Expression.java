package lotto.step1.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private final String expression;
    private static Pattern customDelimiter;
    static {
        customDelimiter = Pattern.compile(Constants.customDelimiterRegex);
    }

    public Expression(String input){
        this.expression = input;
    }

    public String[] integers(){
        Matcher m = customDelimiter.matcher(expression);
        String[] operands;
        if (m.find()) {
            String customDelimiter = m.group(Constants.customDelimiterGroupNumber);
            operands = m.group(Constants.stringGroupNumber).split(customDelimiter);
            checkNumericForArray(operands);
            return operands;
        }
        operands = expression.split(Constants.basicDelimiter);
        checkNumericForArray(operands);
        return operands;
    }

    private void checkNumericForArray(String[] operands){
        Arrays.stream(operands)
                .forEach(this::checkNumericForString);
    }

    private void checkNumericForString(String operand){
        String numberRegExp = Constants.numericRegex;
        if(!operand.matches(numberRegExp)){
            throw new IllegalArgumentException(Constants.checkNumeric);
        }
    }

}
