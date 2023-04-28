package stringcalculator.domain;

import stringcalculator.util.StringParser;
import stringcalculator.util.StringSplitter;

import java.util.List;

public class StringCalculator {

    private int accumulatedNumber;

    public int calculate(String input) {
        List<String> tokens = split(input);

        int sizeOfTokens = tokens.size();
        accumulatedNumber = StringParser.parseInt(tokens.get(0));
        for (int i = 2; i < sizeOfTokens; i += 2) {
            calculateOneStage(tokens, i);
        }
        return accumulatedNumber;
    }

    private List<String> split(String input) {
        validateNullOrEmpty(input);
        return StringSplitter.split(input);
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null과 공백은 입력할 수 없습니다.");
        }
    }

    private void calculateOneStage(List<String> tokens, int i) {
        String operator = tokens.get(i - 1);
        int operand = StringParser.parseInt(tokens.get(i));
        accumulatedNumber = Operator.of(operator)
                .operate(accumulatedNumber, operand);
    }
}
