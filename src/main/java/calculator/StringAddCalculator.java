package calculator;

import calculator.domain.Numbers;
import calculator.domain.TextSplitter;

import java.util.Objects;

public enum StringAddCalculator {
    INSTANCE;

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        TextSplitter textSplitter = new TextSplitter(text);
        Numbers numbers = new Numbers(textSplitter.textToNumbers());
        return numbers.sum().getNumber();
    }
}
