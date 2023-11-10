package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final String input;

    private List<Integer> numbers;
    private List<String> operators;

    private static final String NUMBER_REGEX = "\\d+";
    private static final String OPERATOR_REGEX = "[+-/*]";
    private static final String EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX = "[^\\d-+*/\\s]";

    public StringCalculator(String input) {
        this.input = input;
        inputCheck(input);
        this.numbers = numbers(input);
        this.operators = operators(input);
    }

    private List<String> operators(String input) {
        Pattern pattern = Pattern.compile(OPERATOR_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> operators = new ArrayList<>();
        while(matcher.find()) {
            operators.add(matcher.group());
        }
        return operators;
    }

    private List<Integer> numbers(String input) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<Integer> result = new ArrayList<>();
        while(matcher.find()) {
            result.add(Integer.parseInt(matcher.group()));
        }
        return result;
    }

    private void inputCheck(String input) {
        if(nullOrWhiteSpaceInput(input)){
            throw new IllegalArgumentException("입력 문자열은 null 또는 빈 문자열이어서는 안됩니다.");
        }

        Pattern pattern = Pattern.compile(EXCEPT_NUMBER_OPERATOR_WHITESPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            throw new IllegalArgumentException("입력 문자열에 숫자와 사칙연산 기호 이외의 문자가 포함되어 있습니다.");
        }
    }

    private static boolean nullOrWhiteSpaceInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }
}
