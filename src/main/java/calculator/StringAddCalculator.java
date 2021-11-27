package calculator;

import java.util.Objects;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        Numbers numbers = new Numbers(text);
        return numbers.sum().getNumber();
    }

}
