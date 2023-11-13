package src.domain;

import java.util.Set;

public class Lotto {

    public static final int PRICE_OF_LOTTO = 1000;

    private final Set<GameNumber> numbers;

    public Lotto(Set<GameNumber> numbers) {
        this.numbers = numbers;
    }
}
