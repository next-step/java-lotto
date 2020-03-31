package calculator;

import java.util.Arrays;

public class Calculator {
    public String[] split(String text) {
        return text.split(",");
    }

    public double sum(String text) {
        return Arrays.stream(split(text))
                .mapToDouble(Double::parseDouble)
                .sum();
    }
}
