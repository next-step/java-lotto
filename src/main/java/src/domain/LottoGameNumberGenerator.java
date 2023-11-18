package src.domain;

import java.util.Set;

public interface LottoGameNumberGenerator {
    int LOTTO_NUMBER_COUNT = 6;

    Set<GameNumber> gameNumbers();
}
