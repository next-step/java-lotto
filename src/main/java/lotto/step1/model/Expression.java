package lotto.step1.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private final String expression;
    private static Pattern customDelimiter;
    static {
        customDelimiter = Pattern.compile("//(.)\n(.*)");
    }

    public Expression(String input){
        this.expression = input;
    }

    public String[] integers(){
        Matcher m = customDelimiter.matcher(expression);
        String[] operands;
        if (m.find()) {
            String customDelimiter = m.group(1);
            operands = m.group(2).split(customDelimiter);
        }
        operands = expression.split(",|:");
        checkNumericForArray(operands);
        return operands;
    }

    private void checkNumericForArray(String[] operands){
        Arrays.stream(operands)
                .forEach(this::checkNumericForString);
    }

    private void checkNumericForString(String operand){
        String numberRegExp = "^[0-9]+$";
        if(!operand.matches(numberRegExp)){
            throw new IllegalArgumentException("피연산자는 숫자여야 합니다.");
        }
    }

}
