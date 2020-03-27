package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static List<Integer> LOTTO_NUMBERS = Stream.iterate(1, n -> n + 1).limit(45).collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lotto generate() {
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBERS);

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            numbers.add(LOTTO_NUMBERS.get(i));
        }

        return new Lotto(numbers);
    }
}

