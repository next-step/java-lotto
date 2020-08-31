package calculator.domain;

import java.util.Arrays;

public class Numbers {
    private final String[] numbers;

    public Numbers(String[] numbers) {
        this.numbers = numbers;
        validateNumber();
    }

    public void validateNumber() {
        try {
            if (Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .anyMatch(n -> n < 0)) {
                throw new RuntimeException("음수는 사용할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값을 입력할 수 없습니다.");
        }
    }

    public int sum() {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
