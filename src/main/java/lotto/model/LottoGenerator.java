package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.model.Lotto.SIZE;
import static lotto.model.Number.MAX;
import static lotto.model.Number.MIN;

public class LottoGenerator {

    private static final List<Number> NUMBERS;

    static {
        NUMBERS = IntStream.rangeClosed(MIN, MAX)
                .mapToObj(Number::of)
                .collect(toList());
    }

    public static Lotto generate() {
        shuffle();
        return Lotto.from(getNumbers());
    }

    public static Lotto generate(List<Number> numbers) {
        return Lotto.from(numbers);
    }

    private static void shuffle() {
        Collections.shuffle(NUMBERS);
    }

    private static List<Number> getNumbers() {
        return NUMBERS.stream()
                .limit(SIZE)
                .collect(toList());
    }
}
