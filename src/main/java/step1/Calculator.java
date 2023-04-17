package step1;

import step1.arithmetic.FourArithmeticSymbols;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String values) {
        isBlank(values);

        return sequentialCalculate(split(values));
    }

    private static void isBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException("입력값은 null 또는 빈 값일 수 없습니다.");
        }
    }

    private static List<String> split(String target) {
        return Arrays.asList((target.split(" ")));
    }

    private static int sequentialCalculate(List<String> splitValues) {
        FourArithmeticSymbols symbol;
        int result = Integer.parseInt(splitValues.get(0));

        for (int i = 1; i < splitValues.size() - 1; i += 2) {
            symbol = FourArithmeticSymbols.findBy(splitValues.get(i));
            result = symbol.calculate(result, Integer.parseInt(splitValues.get(i + 1)));
        }

        return result;
    }

    private static void calculateIntegerNumber() {

    }
}
