package calculator;

import java.util.Arrays;

public class SplitNumber {

    private final String[] split;

    public SplitNumber(String[] split) {
        this.split = split;
    }

    public int splitNumberToInt() {
        return Arrays.stream(split)
                .mapToInt(s -> new PositiveNumber(s).getNumber())
                .sum();
    }
}
