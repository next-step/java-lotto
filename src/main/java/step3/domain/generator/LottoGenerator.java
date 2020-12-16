package step3.domain.generator;

import step3.domain.Lotto;

public interface LottoGenerator {
    int LOTTO_COUNT = 6;
    int START_NUMBER = 1;
    int END_NUMBER = 45;

    Lotto generate(String... numbers);
}
