package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class NumberRepository {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 46;

    private static List<Integer> NUMBER_REPOSITORY = initializeNumberRepository();

    private NumberRepository() {
    }

    public static List<Integer> createNonDuplicateNumbers() {
        shuffleNumbers();

        return NUMBER_REPOSITORY.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    private static void shuffleNumbers() {
        Collections.shuffle(NUMBER_REPOSITORY);
    }

    private static List<Integer> initializeNumberRepository() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
