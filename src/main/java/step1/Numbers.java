package step1;

import java.util.Arrays;
import java.util.List;
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

    public int sum() {
        return numbers.stream()
                        .reduce(0, Integer::sum);
    }

}
