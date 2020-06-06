package step2.util;

import step2.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoRandomNumbers {

    private static final List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN, Lotto.MAX)
            .boxed()
            .collect(toList());

    private LottoRandomNumbers() {};

    public static Lotto getRandomNumber() {
        Collections.shuffle(numbers);

        return new Lotto(numbers.stream().limit(Lotto.SIZE).sorted(Integer::compareTo)
                .collect(toList()));
    }
}
