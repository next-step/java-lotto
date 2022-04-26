package me.devyonghee.lotto.model;

import java.util.Objects;

public final class WinnerLotto {

    private static final String NULL_LOTTO_ERROR_MESSAGE = "lotto must not be null";
    private static final String NULL_BONUS_NUMBER_ERROR_MESSAGE = "bonus number must not be null";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE_FORMAT = "lotto numbers(%s) must not contain duplicate number(%s)";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinnerLotto(Lotto lotto, LottoNumber bonusNumber) {
        Objects.requireNonNull(lotto, NULL_LOTTO_ERROR_MESSAGE);
        Objects.requireNonNull(bonusNumber, NULL_BONUS_NUMBER_ERROR_MESSAGE);
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    static WinnerLotto of(Lotto lotto, LottoNumber bonusNumber) {
        return new WinnerLotto(lotto, bonusNumber);
    }

    public Score score(Lottos lottos) {
        return lottos.score(lotto, bonusNumber);
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NUMBER_ERROR_MESSAGE_FORMAT, lotto, bonusNumber));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerLotto that = (WinnerLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }
}
