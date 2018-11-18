package lotto.model;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = Lotto.from(numbers);
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningLotto from(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public Rank getRank(Lotto userLotto) {
        return Rank.valueOf(userLotto.getMatchCount(lotto), userLotto.isContain(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
