package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this(new Lotto(numbers), LottoNumber.of(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNumber> winningNumbers() {
        return this.lotto.numbers();
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
