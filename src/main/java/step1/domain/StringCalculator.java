package step1.domain;

import step1.domain.operator.Operator;
import step1.util.PatternExtractor;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator{

    private static final String NUMBER_REGEX = "\\d+";
    private static final String OPERATOR_REGEX = "[+-/*]";
    private static final String EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX = "[^\\d-+*/\\s]";

    private final List<Operator> operators;

    public StringCalculator(List<Operator> operators) {
        this.operators = operators;
    }

    public int calculate(String input) {
        inputCheck(input);
        LinkedList<Integer> numbers = PatternExtractor.extractAllToLinkedList(input, NUMBER_REGEX);
        List<String> operators = PatternExtractor.extractAllToList(input, OPERATOR_REGEX);
        return calculating(numbers, operators);
    }

    private void inputCheck(String input) {
        if(nullOrWhiteSpaceInput(input)){
            throw new IllegalArgumentException("입력 문자열은 null 또는 빈 문자열이어서는 안됩니다.");
        }
        if(PatternExtractor.isMatch(input, EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX)){
            throw new IllegalArgumentException("입력 문자열에 숫자와 사칙연산 기호 이외의 문자가 포함되어 있습니다.");
        }
    }

    private static boolean nullOrWhiteSpaceInput(String input) {
        return input == null || input.isBlank();
    }

    private int calculating(LinkedList<Integer> numbers, List<String> inputOperators) {
        for (String inputOperator : inputOperators) {
            numbers.push(matchedOperator(inputOperator).operate(numbers.pop(), numbers.pop()));
        }
        return numbers.pop();
    }

    private Operator matchedOperator(String inputOperator) {
        Operator operator = operators.stream()
                .filter(op -> op.supports(inputOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
        return operator;
    }

}
