package io.mwkwon.lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto create(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(winningLotto, bonusLottoNumber);
    }


    public long calcMatchLottoNumberCount(Lotto lotto) {
        return winningLotto.calcMatchLottoNumberCount(lotto);
    }

    public boolean isContainsBonusBall(Lotto lotto) {
        return lotto.isContains(bonusLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusLottoNumber, that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusLottoNumber);
    }
}
