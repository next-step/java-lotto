package lotto.step4.domain;

public interface LottoStrategy {
    static final int LOTTO_NUMBER = 6;
    static final int LOTTO_HEAD_NUMBER = 1;
    static final int LOTTO_LAST_NUMBER = 45;

    Lotto createLotto();
}
