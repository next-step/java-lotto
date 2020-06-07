package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    public static final int RANGE_START = 1;
    public static final int RANGE_CLOSED = 46;

    private final List<Integer> numbers;

    public Numbers() {
        List<Integer> numbers = IntStream.range(RANGE_START, RANGE_CLOSED)
                .boxed().collect(Collectors.toList());
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
