package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WinningLotto {
    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this(new Lotto(numbers), bonusNumber);
    }

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateBonusNumber(this.bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (LottoConfig.MIN_NUMBER > bonusNumber || LottoConfig.MAX_NUMBER < bonusNumber) {
            throw new IllegalArgumentException("보너스 번호의 범위값이 잘못 되었습니다!");
        }
    }

    public Set<Integer> winningNumbers() {
        return this.lotto.numbers();
    }

    public Integer bonusNumber(){
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
