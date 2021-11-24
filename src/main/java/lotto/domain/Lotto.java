package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int bound = 46;
    private static final int size = 6;
    private static final Random r = ThreadLocalRandom.current();

    private final List<LottoNumber> numbers;
    private final Rank rank;

    public Lotto(List<LottoNumber> numbers, Rank rank) {
        this.numbers = numbers;
        this.rank = rank;
    }

    public Lotto(String numbers) {
        this.numbers = createByStrings(numbers);
        this.rank = Rank.NONE;
    }

    public static Lotto createByAuto() {
        List<LottoNumber> numbers = r.ints(1, bound)
            .distinct()
            .limit(size)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(LottoNumber::getNumber));
        return new Lotto(numbers, Rank.NONE);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public Rank getRank() {
        return rank;
    }

    public Lotto createWithWon(Lotto won) {
        Map<Integer, LottoNumber> collect = won.getNumbers()
            .stream()
            .collect(Collectors.toMap(LottoNumber::getNumber, p -> p));
        int match = getMatchPointsBy(collect);
        return new Lotto(this.numbers, Rank.of(match));
    }

    private int getMatchPointsBy(Map<Integer, LottoNumber> map) {
        return (int) numbers.stream()
            .mapToInt(LottoNumber::getNumber)
            .filter(map::containsKey)
            .count();
    }

    private List<LottoNumber> createByStrings(String numbers) {
        return Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
