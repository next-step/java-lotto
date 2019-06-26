package camp.nextstep.edu.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottery {
    private static final int SIZE = 6;
    private static final int ZERO = 0;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final List<Integer> CANDIDATE_NUMBERS = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final Set<Integer> numberSet;

    private Lottery(Set<Integer> numberSet) {
        if (numberSet == null) {
            throw new IllegalArgumentException("'numberSet' must not be null");
        }
        if (numberSet.size() != SIZE) {
            throw new IllegalArgumentException("size of 'numberSet' must be equal to " + SIZE);
        }
        if (numberSet.stream().anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException("'numberSet' must be a number between " + MINIMUM_NUMBER + " and " + MAXIMUM_NUMBER);
        }
        this.numberSet = new HashSet<>(numberSet);
    }

    public static Lottery randomizedInstance() {
        final List<Integer> allNumbers = new ArrayList<>(CANDIDATE_NUMBERS);
        Collections.shuffle(allNumbers);
        final List<Integer> selectedNumbers = allNumbers.subList(ZERO, SIZE);
        final Set<Integer> selectedNumberSet = new HashSet<>(selectedNumbers);
        return new Lottery(selectedNumberSet);
    }

    public static Lottery customizedInstance(Set<Integer> numberSet) {
        return new Lottery(numberSet);
    }

    public int score(Lottery lottery) {
        return (int) numberSet.stream()
                .filter(lottery.numberSet::contains)
                .count();
    }

    public Stream<Integer> stream() {
        return numberSet.stream();
    }
}
