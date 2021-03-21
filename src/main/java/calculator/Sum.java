package calculator;

import java.util.Arrays;

public class Sum {
    private final Splitted splitted;

    public Sum(Splitted splitted) {
        this.splitted = splitted;
    }

    public int sum() {
        return Arrays.stream(splitted.expression())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
