package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lottoNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(Lotto.of(numbers), LottoNumber.of(bonusNumber));
    }

    public Rank getRankByLotto(Lotto lotto) {
        return Rank.valueOf(lotto.getMatchCountByWinningLotto(winningNumbers),
                lotto.hasNumber(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
