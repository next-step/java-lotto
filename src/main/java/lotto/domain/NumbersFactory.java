package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class NumbersFactory {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final List<Integer> NUMBERS_REPOSITORY = initializeNumbersRepository();

    private NumbersFactory() {
    }

    public static LottoNumbers createLottoNumbers() {
        return LottoNumbers.newInstance(createNonDuplicateNumbers());
    }

    private static List<Integer> createNonDuplicateNumbers() {
        shuffleNumbers();

        return NUMBERS_REPOSITORY.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void shuffleNumbers() {
        Collections.shuffle(NUMBERS_REPOSITORY);
    }

    private static List<Integer> initializeNumbersRepository() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
