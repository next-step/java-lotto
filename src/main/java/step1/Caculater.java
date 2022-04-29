package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Caculater {
    private static final String OPERATOR_PATTERN = "[+*/-]";
    private static final String NUMBERS_PATTERN = "[0-9]+";

    private Numbers numbers;
    private Operators operators;

    public Caculater(String input) {
        numbers = findNumber(input);
        operators = findOperator(input);
    }

    private Operators findOperator(String input) {
        Operators operators = new Operators();
        Matcher matcher = Pattern.compile(OPERATOR_PATTERN).matcher(input);
        while(matcher.find()) {
            operators.add(matcher.group());
        }
        return operators;
    }

    private Numbers findNumber(String input) {
        Numbers numbers = new Numbers();
        Matcher matcher = Pattern.compile(NUMBERS_PATTERN).matcher(input);
        while(matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }
        return numbers;
    }

    private int calculation(int operand) {
        String operator = operators.peek();
        for (OperatorCaculate value : OperatorCaculate.values()) {
            if (operator.equals(value.getOperator())) {
                return OperatorCaculate.valueOf(value.name()).caclulate(operand, numbers.pick());
            }
        }
        return 0;
    }

    public int result() {
        int result = numbers.pick();
        while(numbers.isNotEmpty()) {
            result = calculation(result);
        }
        return result;
    }
}
