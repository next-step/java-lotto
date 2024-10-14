package lotto.domain.sales;

import lotto.constant.ErrorMessage;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.prize.LottoPrize;

import java.util.Objects;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto winningLotto, int bonus) {
        this(winningLotto, new LottoNumber(bonus));
    }

    public WinningLotto(Lotto winningLotto, LottoNumber bonus) {
        if (winningLotto.has(bonus)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_BONUS_NUMBER.getMessage(), winningLotto));
        }
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public LottoPrize lottoPrize(Lotto compared) {
        int match = winningLotto.match(compared);
        boolean hasBonus = compared.has(bonus);

        return LottoPrize.from(match, hasBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonus == that.bonus && Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonus);
    }
}
