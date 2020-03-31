package calculator;

import java.util.Arrays;

public class Calculator {

    private Calculator() {}

    public static double sum(String text) {
        if (text == null || "".equals(text.trim())) {
            return 0;
        }

        return Arrays.stream(Tokenizer.split(text))
                .mapToDouble(Calculator::parseDouble)
                .sum();
    }

    private static double parseDouble(String token) {
        double number = Double.parseDouble(token);
        if(number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return number;
    }
}
