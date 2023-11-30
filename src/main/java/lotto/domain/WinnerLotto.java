package lotto.domain;

import java.util.Objects;

public class WinnerLotto {
    protected static final String BONUS_NUMBER_OVERLAPPING_EXCEPTION = "보너스 숫자와 당첨 로또의 숫자가 겹칩니다.";

    private final Lotto winnerLotto;
    private final LottoNumber bonus;

    public WinnerLotto(LottoNumber bonusNumber, Integer... winnerLotto) {
        this(new Lotto(winnerLotto), bonusNumber);
    }

    public WinnerLotto(Lotto winnerLotto, LottoNumber bonusNumber) {
        this.winnerLotto = winnerLotto;
        validateOverlapping(bonusNumber, winnerLotto);
        this.bonus = bonusNumber;
    }

    private void validateOverlapping(LottoNumber bonusLottoNumber, Lotto lotto) {
        if (isOverlapping(bonusLottoNumber, lotto)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OVERLAPPING_EXCEPTION);
        }
    }

    private boolean isOverlapping(LottoNumber bonusLottoNumber, Lotto lotto) {
        return lotto.isOverlapping(bonusLottoNumber);
    }

    public Rank findRankOf(Lotto lotto) {
        int countOfMatch = this.winnerLotto.countOfMatch(lotto);
        boolean containsBonus = lotto.isOverlapping(this.bonus);
        return Rank.valeOf(countOfMatch, containsBonus);
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
        return Objects.equals(winnerLotto, that.winnerLotto) && Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerLotto, bonus);
    }
}
