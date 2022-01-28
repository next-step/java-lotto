package calculator.domain;

import java.util.Objects;

public class StringCalculator {

    public int add(String text) {
        return validateText(text);
    }

    public int validateText(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
