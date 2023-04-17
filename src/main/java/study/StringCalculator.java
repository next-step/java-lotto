package study;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.*;
import static java.lang.System.in;

public class StringCalculator {

    public static final String OPERATOR_REGEX = " \\+ | \\- | \\* | \\/ ";
    public static final String NUMBER_REGEX = "[0-9]+";
    public static final String PLUS = "+";
    public static final String TIMES = "*";
    public static final String DIVIDE = "/";
    public static final String MINUS = "-";

    private static final Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        out.println("계산하고자 하는 문자열을 입력하세요");
        String input = scanner.nextLine();
        int calc = calc(input);
        out.println("input : " + input);
        out.println("output : " + calc);
    }

    public static int calc(String input) {
        illegalArgumentCondition(input);

        List<Integer> integers = extractNumbers(input);
        List<String> operators = extractOperators(input);

        return combineNumbersWithOperators(integers, operators);
    }

    private static int combineNumbersWithOperators(List<Integer> integers, List<String> operators) {
        int result = getTargetNumber(integers, 0);
        for (int i = 1; i < integers.size(); i++) {
            result = operate(result, getOperators(operators, i - 1), getTargetNumber(integers, i));
        }
        return result;
    }

    private static String getOperators(List<String> operators, int i) {
        return operators.get(i).trim();
    }

    private static int getTargetNumber(List<Integer> integers, int i) {
        return integers.get(i);
    }

    private static void illegalArgumentCondition(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static int operate(int num1, String op, int num2) {
        if (op.equals(PLUS)) return num1 + num2;
        if (op.equals(MINUS)) return num1 - num2;
        if (op.equals(TIMES)) return num1 * num2;
        if (op.equals(DIVIDE)) return num1 / num2;
        throw new IllegalArgumentException();
    }

    public static List<String> extractOperators(String input) {
        String[] split2 = input.split(NUMBER_REGEX);
        return Arrays.stream(split2)
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }

    public static List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(OPERATOR_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
