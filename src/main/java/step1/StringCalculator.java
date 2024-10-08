package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String IS_NUMBER_REGEX = "[0-9]+";
    private static final String BLANK = " ";

    public int splitAndCalculate(String text) {
        inputValidate(text);

        String[] tokens = splitByBlank(text);

        List<Integer> operandList = findOperand(tokens);
        List<String> operatorList = findOperator(tokens);

        Calculator calculator = new Calculator(operandList, operatorList);

        return calculator.calculate();
    }

    private void inputValidate(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("입력값은 필수입니다.");
        }

        String[] tokens = splitByBlank(text);
        for (String token : tokens) {
            if (!token.matches(IS_NUMBER_REGEX) && !Operation.hasOperator(token)) {
                throw new IllegalArgumentException("올바른 사칙연산이 아닙니다.");
            }
        }
    }

    private List<Integer> findOperand(String[] tokens) {
        return Arrays.stream(tokens)
                     .filter(token -> token.matches(IS_NUMBER_REGEX))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private List<String> findOperator(String[] tokens) {
        return Arrays.stream(tokens)
                     .filter(Operation::hasOperator)
                     .collect(Collectors.toList());
    }

    private String[] splitByBlank(String text) {
        return text.split(BLANK);
    }

}
