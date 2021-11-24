package lotto.domain;

import calculator.PositiveNumber;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int bound = 46;
    private static final int size = 6;
    private static final Random r = ThreadLocalRandom.current();

    private final List<PositiveNumber> numbers;
    private final Rank rank;

    public Lotto(List<PositiveNumber> numbers, Rank rank) {
        this.numbers = numbers;
        this.rank = rank;
    }

    public Lotto(String numbers) {
        this.numbers = createByStrings(numbers);
        this.rank = Rank.NONE;
    }

    public static Lotto createByAuto() {
        List<PositiveNumber> numbers = r.ints(1, bound)
            .distinct()
            .limit(size)
            .mapToObj(PositiveNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(PositiveNumber::getNumber));
        return new Lotto(numbers, Rank.NONE);
    }

    public List<PositiveNumber> getNumbers() {
        return numbers;
    }

    public Rank getRank() {
        return rank;
    }

    public Lotto createWithWon(Lotto won) {
        Map<Integer, PositiveNumber> collect = won.getNumbers()
            .stream()
            .collect(Collectors.toMap(PositiveNumber::getNumber, p -> p));
        int match = getMatchPointsBy(collect);
        return new Lotto(this.numbers, Rank.of(match));
    }

    private int getMatchPointsBy(Map<Integer, PositiveNumber> map) {
        return (int) numbers.stream()
            .mapToInt(PositiveNumber::getNumber)
            .filter(map::containsKey).count();
    }

    private List<PositiveNumber> createByStrings(String numbers) {
        return Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(PositiveNumber::new)
            .collect(Collectors.toList());
    }
}
