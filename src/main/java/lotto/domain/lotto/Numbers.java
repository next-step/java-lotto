package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 46;

    private final List<Integer> numbers;

    public Numbers() {
        List<Integer> numbers = IntStream.range(START_NUMBER, END_NUMBER)
                .boxed().collect(Collectors.toList());
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    private void checkNumberRange(List<Integer> numbers) {
        if (isInRange(numbers)) {
            throw new IllegalArgumentException("유효 범위 내 값이 아닙니다.");
        }
    }

    private boolean isInRange(List<Integer> numbers) {
        return Collections.max(numbers) < START_NUMBER
                || Collections.max(numbers) >= END_NUMBER;
    }
}
