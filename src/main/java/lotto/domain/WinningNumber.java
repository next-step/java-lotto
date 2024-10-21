package lotto.domain;

import java.util.Set;

public class WinningNumber {
    private static final String BONUS_DUPLICATE_ERROR_MESSAGE = "보너스번호는 당첨번호와 중복될 수 없습니다.";

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(final Set<Integer> winningNumbers, final int bonusNumber) {
        this(Lotto.from(winningNumbers), LottoNumber.from(bonusNumber));
    }

    public WinningNumber(final Lotto winningNumber, final LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public LottoRewards findLottoRewards(final Lotto lotto) {
        return LottoRewards.from(winningNumber.countMatchCount(lotto), hasBonusNumber(lotto));
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    private void validateBonusNumber() {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
