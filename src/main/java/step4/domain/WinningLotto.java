package step4.domain;

import java.util.Objects;

public class WinningLotto {
    private static final String CONTAINS_EXCEPTION_MESSAGE = "보너스 숫자는 당첨로또에 포함될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonus;

    private WinningLotto(Lotto winningLotto, LottoNumber bonus) {
        if (winningLotto.containLottoNumber(bonus)) {
            throw new IllegalArgumentException(CONTAINS_EXCEPTION_MESSAGE);
        }
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(String lottoString, String num) {
        return new WinningLotto(Lotto.of(lottoString), LottoNumber.of(num));
    }

    public boolean checkLottoHasBouns(Lotto lotto) {
        return lotto.containLottoNumber(bonus);
    }

    public long countOfMatch(Lotto lotto) {
        return winningLotto.countOfMatch(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonus);
    }
}
