package step4.domain.generator;

import step4.domain.Lotto;

public interface LottoGenerator {
    int LOTTO_COUNT = 6;
    int START_NUMBER = 1;
    int END_NUMBER = 45;

    Lotto generate(String... varargs);
    boolean isNotMatchArgs(String... varargs);
}
