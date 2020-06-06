package lotto.domain.lotto;

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
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
