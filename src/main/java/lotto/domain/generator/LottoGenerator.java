package lotto.domain.generator;

import lotto.domain.lotto.LottoNumbers;

public interface LottoGenerator {
    int LOTTO_NUMBERS = 6;
    int LOTTO_MIN_NUMBER = 1;
    int LOTTO_MAX_NUMBER = 45;

    LottoNumbers generateNumbers();
}
