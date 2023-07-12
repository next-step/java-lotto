package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomNumbersGenerator implements NumbersGenerator {

    private static final int MINIMUM_INDEX = 0;
    private static final RandomNumbersGenerator INSTANCE = new RandomNumbersGenerator();

    private static final List<Integer> baseNumbers = IntStream
            .rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toUnmodifiableList());

    private RandomNumbersGenerator() {
    }

    public static RandomNumbersGenerator getInstance() {
        return INSTANCE;
    }

    private static List<Integer> sort(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Integer> shuffleBaseNumbers() {
        final List<Integer> copiedNumbers = new ArrayList<>(baseNumbers);
        Collections.shuffle(copiedNumbers);
        return copiedNumbers;
    }

    @Override
    public List<Integer> generate() {
        return sort(shuffleBaseNumbers().subList(MINIMUM_INDEX, Lotto.LOTTO_NUMBERS_SIZE));
    }
}
