package stringcalculator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Calculator {

    public static final String DELIMITER = " ";

    public void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사칙연산을 수행하기 위한 문자열을 입력해주세요: ");
        final String input = scanner.nextLine();
        final List<String> subjects = splitWithSpace(input);
        System.out.println(process(subjects));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public List<String> splitWithSpace(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다: " + input);
        }

        return List.of(input.split(DELIMITER));
    }

    public int process(List<String> input) {
        int result = this.parseOrThrow(input.get(0));

        for (int i = 1; i < input.size(); i = i + 2) {
            int number = this.parseOrThrow(input.get(i + 1));
            final String operator = input.get(i);
            result = this.operate(operator, result, number);
        }

        return result;
    }

    private int operate(String symbol, int a, int b) {
        Operator operator = Operator.getBySymbol(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + symbol);
        }
        return operator.operate(a, b);
    }

    private int parseOrThrow(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + element);
        }
    }
}
