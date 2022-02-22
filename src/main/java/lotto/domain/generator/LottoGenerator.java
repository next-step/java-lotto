package lotto.domain.generator;

import lotto.domain.lotto.LottoNumbers;

public interface LottoGenerator {
    int LOTTO_NUMBERS = 6;
    int START_NUMBER = 1;
    int END_NUMBER = 45;

    LottoNumbers generateNumbers();
}
