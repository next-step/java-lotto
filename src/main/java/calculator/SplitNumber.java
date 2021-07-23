package calculator;

import java.util.Arrays;

public class SplitNumber {

    private final String[] split;

    public SplitNumber(String[] split) {
        this.split = split;
    }

    public int splitNumberToInt() {
        return Arrays.stream(split)
                .mapToInt(this::getValue)
                .sum();
    }

    private int getValue(String str) {
        int num = Integer.parseInt(str);
        validate(num);

        return num;
    }

    private void validate(int num) {
        if (num < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }
}
