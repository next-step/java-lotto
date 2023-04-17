package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    public static int ZERO = 0;
    public static int ODD_RESULT = 1;
    public static int EVEN_CONDITION = 2;
    public static String[] OPERATORS = {"+", "-", "*", "/"};

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
        IntStream.range(ZERO, expressionList.size())
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
        return List.of(OPERATORS).contains(operator);
    }

    private void validateSize(List<String> expressionList) {
        if (isEven(expressionList.size()) || hasOnlyOneSize(expressionList)) {
            throw new IllegalArgumentException("계산식을 정확히 입력해주세요.");
        }
    }

    private boolean isEven(int number) {
        return number % EVEN_CONDITION == ZERO;
    }

    private boolean isOdd(int number) {
        return number % EVEN_CONDITION == ODD_RESULT;
    }

    private boolean hasOnlyOneSize(List<String> expressionList) {
        return expressionList.size() == ODD_RESULT;
    }

    public static Expression createExpression(String[] inputString) {
        return new Expression(List.of(inputString));
    }

    public int getSize() {
        return expressionList.size();
    }

    public Queue<Operator> getOperators() {
        return IntStream.range(ZERO, expressionList.size())
                .filter(i -> i % EVEN_CONDITION == ODD_RESULT)
                .mapToObj(i -> Operator.getOperator(expressionList.get(i)))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List<Integer> getOperands() {
        return IntStream.range(ZERO, expressionList.size())
                .filter(i -> i % EVEN_CONDITION == ZERO)
                .mapToObj(i -> Integer.parseInt(expressionList.get(i)))
                .collect(Collectors.toList());
    }
}
