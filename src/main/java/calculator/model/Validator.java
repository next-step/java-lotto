package calculator.model;

import java.util.List;

public class Validator {

    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");
    private String beforeCharacter = "";


    public void validate(String[] numberSentence) {
        for (int index = 0; index < numberSentence.length; index++) {
            String expression = numberSentence[index];
            expressionInspectionByIndex(index, numberSentence.length-1, expression);
            beforeCharacter = expression;
        }
    }

    private void expressionInspectionByIndex(int index, int lastIndex, String expression) {
        if (index == 0 && isOperator(expression)) {
            throw new IllegalArgumentException("수식의 처음엔 연산자가 올 수 없습니다");
        }
        if (index != 0) {
            checkDuplicated(expression);
            checkValidOperator(expression);
        }
        if (index == lastIndex && isOperator(expression)) {
            throw new IllegalArgumentException("수식의 마지막엔 연산자가 올 수 없습니다");
        }
    }

    private void checkValidOperator(String input) {
        if (!isNumber(input) && !isOperator(input)) {
            throw new IllegalArgumentException("숫자나 연산자가 아닌 문자는 들어올 수 없습니다");
        }
    }

    private void checkDuplicated(String input) {
        if (isOperator(input) && isOperator(beforeCharacter)) {
            throw new IllegalArgumentException("연산자는 연속으로 두 개가 올 수 없습니다");
        }
        if (!isOperator(input) && !isOperator(beforeCharacter)) {
            throw new IllegalArgumentException("숫자는 연속으로 두 개가 올 수 없습니다");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String input) {
        return OPERATORS.contains(input);
    }

    public void nullCheck(String numberSentence) {
        if (numberSentence.isBlank() || numberSentence.isEmpty()) {
            throw new IllegalArgumentException("계산할 수식을 적어주세요");
        }
    }
}
