package lotto.model.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomNumbersGenerator implements NumbersGenerator {

    private static final int MINIMUM_INDEX = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final List<Integer> baseNumbers = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toUnmodifiableList());

    private RandomNumbersGenerator() {
    }

    private static class RandomNumberGeneratorHolder {

        private static final RandomNumbersGenerator INSTANCE = new RandomNumbersGenerator();
    }

    public static RandomNumbersGenerator getInstance() {
        return RandomNumberGeneratorHolder.INSTANCE;
    }

    @Override
    public List<Integer> generate() {
        return sort(shuffleBaseNumbers());
    }

    private static List<Integer> sort(final List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> shuffleBaseNumbers() {
        final List<Integer> copiedNumbers = new ArrayList<>(baseNumbers);
        Collections.shuffle(copiedNumbers);
        return new ArrayList<>(copiedNumbers.subList(MINIMUM_INDEX, LOTTO_SIZE));
    }
}
