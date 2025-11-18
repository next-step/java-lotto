package calculator;

import static java.lang.Integer.parseInt;
import static java.util.Objects.isNull;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CalculateTargetInput {

    private static final String NUM_AND_OPERATOR_DELIMITER = " ";
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("[-+]?\\d*\\.?\\d+");
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public final String input;

    public CalculateTargetInput(String input) {
        if (isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없거나 빈 문자열 입니다");
        }

        this.input = input;
    }

    public List<String> validAndSplitInput() {
        String[] inputArrays = trimAndSplit();
        if (inputArrays.length < 2) {
            throw new IllegalArgumentException("입력값이 하나이거나 비정상 문자열 입니다");
        }

        for (int index = 0; index < inputArrays.length; index++) {
            validInputByIndex(index, inputArrays);
        }

        return List.of(inputArrays);
    }

    private String[] trimAndSplit() {
        return this.input.trim().split(NUM_AND_OPERATOR_DELIMITER);
    }

    private boolean isEvenNum(int number) {
        return number % 2 == 0;
    }

    private boolean isOddNum(int number) {
        return number % 2 == 1;
    }

    private void validInputByIndex(int index, String[] inputArrays) {
        if (isEvenNum(index)) {
            validNumber(inputArrays[index]);
            return;
        }

        if (isOddNum(index)) {
            validOperator(inputArrays[index]);
        }
    }

    private void validNumber(String inputArrays) {
        if (POSITIVE_NUMBER_PATTERN.matcher(inputArrays).matches()) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다. 정해진 입력값 양식에 맞춰 작성해주세요");
        }
    }

    private void validOperator(String inputArrays) {
        if (!OPERATORS.contains(inputArrays)) {
            throw new IllegalArgumentException("입력값이 연산자가 아닙니다. 정해진 입력값 양식에 맞춰 작성해주세요");
        }
    }
}
