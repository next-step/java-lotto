package net.chandol.lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public final class RandomLottoNumberProvider {
    public static List<Integer> getNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(toList());

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
