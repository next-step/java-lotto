package src.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoGameNumberGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;

    public Set<GameNumber> gameNumbers() {
        Set<GameNumber> gameNumbers = new HashSet<>(LOTTO_NUMBER_COUNT);
        for (int idx = 0; idx < LOTTO_NUMBER_COUNT; idx++) {
            gameNumbers.add(GameNumber.random());
        }

        return gameNumbers;
    }
}
