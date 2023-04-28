package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SPLIT_REG_EXP = " ";
    private static final Pattern NUMBER_CHECK_PATTERN = Pattern.compile("[^0-9 +\\-*/]");

    public void isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> split(String input) {
        return Arrays.asList(input.split(SPLIT_REG_EXP));
    }

    public boolean isOnlyNumAndOperator(String input) {
        Matcher matcher = NUMBER_CHECK_PATTERN.matcher(input);
        return !matcher.find();
    }

    public int calculate(String input) {
        List<String> operands = split(input);
        int operand1 = convertInt(operands.get(0));
        for (int i = 1; i < operands.size(); i += 2) {
            String operator = operands.get(i);
            int operand2 = convertInt(operands.get(i + 1));
            operand1 =  Operator.calculate(operator, operand1, operand2);
        }
        return operand1;
    }

    private int convertInt(String str) {
        return Integer.parseInt(str);
    }
}
