package calculator.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Expression {

    private final List<String> expressionList;

    private Expression(List<String> expressionList) {
        validationCheck(expressionList);
        this.expressionList = expressionList;
    }

    private void validationCheck(List<String> expressionList) {
        validateSize(expressionList);
        validateElement(expressionList);
    }

    private void validateElement(List<String> expressionList) {
        IntStream.range(0, expressionList.size())
                .forEach(index -> {
                    checkNumberFormat(index, expressionList.get(index));
                    checkOperators(index, expressionList.get(index));
                });
    }

    private void checkNumberFormat(int index, String numberFormat) {
        if (isEven(index)) {
            validateNumberFormat(numberFormat);
        }
    }

    private void validateNumberFormat(String numberFormat) {
        try {
            Integer.parseInt(numberFormat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 하는 위치입니다.");
        }
    }

    private void checkOperators(int index, String operator) {
        if (isOdd(index) && !hasOperators(operator)) {
            throw new IllegalArgumentException("올바른 계산식을 입력해주세요.");
        }
    }

    private boolean hasOperators(String operator) {
        return List.of("+", "-", "*", "/").contains(operator);
    }

    private void validateSize(List<String> expressionList) {
        if (isEven(expressionList.size()) || hasOnlyOneSize(expressionList)) {
            throw new IllegalArgumentException("계산식을 정확히 입력해주세요.");
        }
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private boolean hasOnlyOneSize(List<String> expressionList) {
        return expressionList.size() == 1;
    }

    public static Expression createExpression(String[] inputString) {
        return new Expression(List.of(inputString));
    }

    public int getSize() {
        return expressionList.size();
    }
}
