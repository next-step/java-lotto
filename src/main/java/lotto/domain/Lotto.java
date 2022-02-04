package lotto.domain;

import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String NOT_VALIDATE_LOTTO_MESSAGE = "[ERROR] 로또는 중복되지 않은 6개의 숫자가 필요합니다.";

    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
        validateLotto();
    }

    public int count() {
        return lotto.size();
    }

    private void validateLotto() {
        if (lottoSizeNotValid()) {
            throw new IllegalArgumentException(NOT_VALIDATE_LOTTO_MESSAGE);
        }
    }

    private boolean lottoSizeNotValid() {
        return lotto.size() != LOTTO_SIZE;
    }
}
