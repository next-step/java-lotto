package lotto.domain;

import java.util.Set;

public class WinningNumber {
    private static final String BONUS_DUPLICATE_ERROR_MESSAGE = "보너스번호는 당첨번호와 중복될 수 없습니다.";

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(final Set<LottoNumber> winningNumbers) {
        this.winningNumber = new Lotto(winningNumbers);
        this.bonusNumber = null;
    }

    public WinningNumber(final Set<LottoNumber> winningNumbers, final int bonusNumber) {
        this.winningNumber = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateBonusNumber();
    }

    public LottoRewards findLottoRewards(final Lotto lotto) {
        return LottoRewards.getLottoRewards(winningNumber.countMatchCount(lotto));
    }

    private void validateBonusNumber() {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
