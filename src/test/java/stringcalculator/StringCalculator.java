package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String OPERATION_REGEX = "[+\\-*/]+";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String NOT_VALID_REGEX = "[^\\d+\\-*/^\\s]";

    public static int calculate(String input) {
        containsOnlyValidCharacters(input);
        List<Integer> numbers = toInts(getCharacters(input, NUMBER_REGEX));
        List<String> operations = getCharacters(input, OPERATION_REGEX);
        int result = numbers.get(0);
        for (int i = 0; i < operations.size(); i++) {
            result = operate(numbers, operations, result, i);
        }
        return result;
    }

    private static int operate(List<Integer> numbers, List<String> operations, int result, int i) {
        result = plus(numbers, operations, result, i);
        result = minus(numbers, operations, result, i);
        result = divide(numbers, operations, result, i);
        result = multiple(numbers, operations, result, i);
        return result;
    }

    private static int multiple(List<Integer> numbers, List<String> operations, int result, int i) {
        if (operations.get(i).equals("/")) {
            result /= numbers.get(i + 1);
        }
        return result;
    }

    private static int divide(List<Integer> numbers, List<String> operations, int result, int i) {
        if (operations.get(i).equals("*")) {
            result *= numbers.get(i + 1);
        }
        return result;
    }

    private static int minus(List<Integer> numbers, List<String> operations, int result, int i) {
        if (operations.get(i).equals("-")) {
            result -= numbers.get(i + 1);
        }
        return result;
    }

    private static int plus(List<Integer> numbers, List<String> operations, int result, int i) {
        if (operations.get(i).equals("+")) {
            result += numbers.get(i + 1);
        }
        return result;
    }

    private static List<String> getCharacters(String input, String regex) {
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String op = matcher.group();
            operations.add(op);
        }
        return operations;
    }

    private static List<Integer> toInts(List<String> strings) {
        List<Integer> ints = new ArrayList<>();
        for (String string : strings) {
            ints.add(Integer.parseInt(string));
        }
        return ints;
    }

    private static void containsOnlyValidCharacters(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }

        if (Pattern.compile(NOT_VALID_REGEX).matcher(input).find()) {
            throw new IllegalArgumentException("사칙연산 기호를 입력해주세요.");
        }
    }
}
