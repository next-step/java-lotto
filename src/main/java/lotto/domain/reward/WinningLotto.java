package lotto.domain.reward;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningLotto(final Lotto lotto, final LottoNumber bonus) {
        validateBonusNotContainsLotto(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateBonusNotContainsLotto(final Lotto lotto, final LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("로또 번호에 있는 번호는 보너스 번호로 사용 할 수 없습니다. 번호: " + bonus);
        }
    }

    public LottoRank match(final Lotto lotto) {
        final int matchingCount = lotto.matchCount(this.lotto);
        final boolean isMatchedBonus = lotto.contains(this.bonus);

        return LottoRank.from(matchingCount, isMatchedBonus);
    }

    public static WinningLotto of(final List<Integer> numbers, final int bonusNumber) {
        final Lotto lotto = Lotto.from(numbers);
        final LottoNumber bonus = new LottoNumber(bonusNumber);

        return new WinningLotto(lotto, bonus);
    }
}
