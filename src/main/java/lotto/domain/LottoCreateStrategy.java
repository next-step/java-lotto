package lotto.domain;

public interface LottoCreateStrategy {
    int LOTTO_SIZE = 6;

    Lotto create(LottoNumbers balls);
}
