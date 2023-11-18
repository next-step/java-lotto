package src.domain;

import java.util.Set;

public class Lotto {

    public static final int PRICE_OF_LOTTO = 1000;

    public static final int LOTTO_GAME_NUMBER_SIZE = 6;

    private final Set<GameNumber> numbers;

    private Lotto(Set<GameNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(Set<GameNumber> numbers) {
        if(numbers.size() != LOTTO_GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 번호는 6자리입니다.");
        }

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
