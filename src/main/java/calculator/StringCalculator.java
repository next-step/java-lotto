package calculator;

import java.util.List;

public class StringCalculator {

    private StringCalculator() {}

    public static Number sum(String data) {
        NumberSplitter numberSplitter = new NumberSplitter();
        List<Number> numbers = numberSplitter.split(data);
        return numbers.stream()
                .reduce(Number::sum)
                .orElseThrow(() -> new ArithmeticException("계산 중 잘못되어 null 이 반환되었습니다"));
    }
}
