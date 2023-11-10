package step1.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator extends Calculator{

    private final Stack<Integer> numbers;
    private final List<String> operators;

    private static final String NUMBER_REGEX = "\\d+";
    private static final String OPERATOR_REGEX = "[+-/*]";
    private static final String EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX = "[^\\d-+*/\\s]";

    public StringCalculator(String input) {
        inputCheck(input);
        this.numbers = numbers(input);
        this.operators = operators(input);
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

    private List<String> operators(String input) {
        Pattern pattern = Pattern.compile(OPERATOR_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> operators = new LinkedList<>();
        while(matcher.find()) {
            operators.add(matcher.group());
        }
        return operators;
    }

    private Stack<Integer> numbers(String input) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(input);
        Stack<Integer> inputNumbers = new Stack<>();
        while(matcher.find()) {
            inputNumbers.push(Integer.parseInt(matcher.group()));
        }
        Stack<Integer> result = new Stack<>();
        while(!inputNumbers.isEmpty()){
            result.push(inputNumbers.pop());
        }
        return result;
    }

    private void inputCheck(String input) {
        if(nullOrWhiteSpaceInput(input)){
            throw new IllegalArgumentException("입력 문자열은 null 또는 빈 문자열이어서는 안됩니다.");
        }
        invalidCharCheck(input);
    }

    private static boolean nullOrWhiteSpaceInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static void invalidCharCheck(String input) {
        Pattern pattern = Pattern.compile(EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            throw new IllegalArgumentException("입력 문자열에 숫자와 사칙연산 기호 이외의 문자가 포함되어 있습니다.");
        }
    }

}
