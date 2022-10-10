package lotto.strategy;

import lotto.domain.Lotto;

public interface ExtractStrategy {
    int MIN_LOTTO_NUMBER = 1;
    int MAX_LOTTO_NUMBER = 45;
    int WIN_COUNT = 6;
    Lotto extractNumber();
}
