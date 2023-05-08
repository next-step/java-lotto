package lotto.step4.domain;

public interface LottoStrategy {
    int LOTTO_NUMBER = 6;
    int LOTTO_HEAD_NUMBER = 1;
    int LOTTO_LAST_NUMBER = 45;

    Lotto createLotto();
}
