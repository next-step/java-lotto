package src.domain;

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

    public int matchCount(Lotto lotto) {
        return (int) this.numbers.stream().filter(lotto.numbers::contains).count();
    }

    public boolean matchBonus(GameNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
