package calculator;

import java.util.Arrays;

public class Calculator {
    public String[] split(String text) {
        return text.split(",");
    }

    public double sum(String text) {
        return Arrays.stream(split(text))
                .mapToDouble(this::parseDouble)
                .sum();
    }

    private double parseDouble(String token) {
        double number = Double.parseDouble(token);
        if(number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return number;
    }
}
