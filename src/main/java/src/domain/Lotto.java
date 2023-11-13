package src.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lotto {

    public static final int PRICE_OF_LOTTO = 1000;

    private final Set<GameNumber> numbers;

    private Lotto(Set<GameNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(Set<GameNumber> numbers) {
        return new Lotto(numbers);
    }

    public Place match(Lotto lotto) {
        Map<Boolean, Integer> matchStatus = new HashMap<>(2);

        for (GameNumber gameNumber: lotto.numbers) {
            Integer value = matchStatus.getOrDefault(numbers.contains(gameNumber), 0);
            matchStatus.put(numbers.contains(gameNumber), value + 1);
        }

        return Place.byMatchedCount(matchStatus.getOrDefault(Boolean.TRUE, 0));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
