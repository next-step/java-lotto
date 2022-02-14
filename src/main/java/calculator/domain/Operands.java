package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private static final int LIMIT_MINIMUM_NUMBER = 0;

    private final String[] numbers;

    public Operands(String[] numbers) {
        this.numbers = numbers;
    }

    public List<Integer> castToInteger() {
        try {
            return Arrays.stream(numbers)
                .map(value -> {
                    final Integer number = Integer.parseInt(value);
                    validPositiveNumber(number);
                    return number;
                }).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private void validPositiveNumber(Integer value) {
        if (value < LIMIT_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 음수 값은 입력할 수 없습니다.");
        }
    }
}
