package step1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Numbers {

    public static final int MIN_VALUE = 0;

    private final List<Integer> numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(this::validateNumberIsPositiveAndReturnValue)
                .collect(Collectors.toList());
    }

    private int validateNumberIsPositiveAndReturnValue(String number) {
        int value = Integer.parseInt(number);
        if(value < MIN_VALUE) {
            throw new RuntimeException("0 이상의 값만 입력 가능합니다.");
        }
        return value;
    }

    public boolean hasOneNumber() {
        return numbers.size() == 1;
    }

    public int pickFirstValueIfHasOneNumber() {
        if (!hasOneNumber()) {
            throw new RuntimeException("하나의 숫자만 가지고 있어야 합니다.");
        }
        return numbers.get(0);
    }

    public int sum() {
        return hasOneNumber() ?
                pickFirstValueIfHasOneNumber() :
                numbers.stream()
                        .reduce(0, Integer::sum);
    }

}
