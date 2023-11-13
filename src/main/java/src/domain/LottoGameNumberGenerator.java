package src.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoGameNumberGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;

    public Set<GameNumber> gameNumbers() {
        Set<GameNumber> gameNumbers = new HashSet<>(LOTTO_NUMBER_COUNT);
        while (gameNumbers.size() < LOTTO_NUMBER_COUNT) {
            gameNumbers.add(GameNumber.random());
        }

        return gameNumbers;
    }
}
