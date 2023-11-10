package step1.domain;

import step1.util.PatternExtractor;

import java.util.List;
import java.util.Stack;

public class StringCalculator extends Calculator{

    private final Stack<Integer> numbers;
    private final List<String> operators;

    private static final String NUMBER_REGEX = "\\d+";
    private static final String OPERATOR_REGEX = "[+-/*]";
    private static final String EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX = "[^\\d-+*/\\s]";

    public StringCalculator(String input) {
        inputCheck(input);
        this.numbers = reverseStack(PatternExtractor.stack(input, NUMBER_REGEX));
        this.operators = PatternExtractor.extractAll(input, OPERATOR_REGEX);
    }

    public int result() {
        calculating();
        return numbers.pop();
    }

    private void calculating() {
        for(String operator: operators){
            numbers.push(calculate(operator, numbers.pop(), numbers.pop()));
        }
    }

    private Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();
        while(!stack.isEmpty()){
            result.push(stack.pop());
        }
        return result;
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
        return input == null || input.trim().isEmpty();
    }

}
