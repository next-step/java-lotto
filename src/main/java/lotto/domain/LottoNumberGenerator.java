package lotto.domain;

import java.util.Set;

public interface LottoNumberGenerator {
    int LOTTO_NUMBERS_SIZE = 6;
    int LOTTO_NUMBER_LOWER_LIMIT = 1;
    int LOTTO_NUMBER_UPPER_LIMIT = 45;

    Set<Integer> generateNumbers();
}
