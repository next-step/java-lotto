package step1;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Numbers {

    private final int[] numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .mapToInt(this::validateNumberIsPositiveAndReturnValue)
                .toArray();
    }

    private int validateNumberIsPositiveAndReturnValue(String number) {
        int value = Integer.parseInt(number);
        if(value < 0) {
            throw new RuntimeException("0 이상의 값만 입력 가능합니다.");
        }
        return value;
    }

    public boolean hasOneNumber() {
        return numbers.length == 1;
    }

    public int pickFirstValueIfHasOneNumber() {
        if (!hasOneNumber()) {
            throw new RuntimeException("하나의 숫자만 가지고 있어야 합니다.");
        }
        return numbers[0];
    }

    public int sumNumbers() {
        return hasOneNumber() ?
                pickFirstValueIfHasOneNumber() :
                Arrays.stream(numbers)
                        .reduce(0, Integer::sum);
    }

}
