package calculator;

import java.util.Arrays;

public class Validate {

    public void validate(String[] numbers) {
        if (negative(numbers)) {
            throw new RuntimeException("음수를 입력 할 수 없습니다.");
        }
    }

    private boolean negative(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).anyMatch(number -> number < 0);
    }
}
