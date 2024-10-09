package calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final List<String> arithmeticSymbols = Arrays.asList("+", "-", "*", "/");
    private static Scanner scanner = new Scanner(System.in);

    public static void input() {
        System.out.println("계산식을 입력해주세요.");
        String text = scanner.nextLine();

        if (isNullOrBlank(text)) return;

        List<String> expressionElements = List.of(text.split(" "));

        String symbol = "";
        List<Integer> numbers = new ArrayList<>();

        for (String e : expressionElements) {
            if (isNumberic(e)) {
                numbers.add(Integer.valueOf(e));
            }
            if (!isNumberic(e) && isArithmeticSymbol(e)) {
                symbol = e;
            }
            if (numbers.size() == 2) {
                numbers.add(Calculator.calculate(symbol, numbers.remove(0), numbers.remove(0)));
            }
        }

        System.out.println(numbers.get(0));
    }

    private static boolean isNumberic(String str) {
        return str.matches("\\d*");
    }

    public static boolean isNullOrBlank(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("null이거나 빈 공백 문자열입니다.");
        }
        return false;
    }

    public static boolean isArithmeticSymbol(String symbol) {
        if (!arithmeticSymbols.contains(symbol)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다. " + symbol);
        }
        return true;
    }
}
