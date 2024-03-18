package lotto.model;

import lotto.exception.InvalidLottoException;

import static lotto.validation.WinningInfoValidator.assertDuplicatedBonus;

public class WinningInfo {
    private final Lotto winningNumberLotto;
    private final LottoNumber bonusNumber;

    public WinningInfo(Lotto winningNumberLotto, LottoNumber bonusNumber) {
        assertNull(winningNumberLotto, bonusNumber);
        assertDuplicatedBonus(winningNumberLotto, bonusNumber);

        this.winningNumberLotto = winningNumberLotto;
        this.bonusNumber = bonusNumber;
    }

    private void assertNull(Lotto winningNumberLotto, LottoNumber bonusNumber) {
        if (winningNumberLotto == null) {
            throw new InvalidLottoException("당첨 번호가 존재하지 않습니다");
        }

        if (bonusNumber == null) {
            throw new InvalidLottoException("보너스 번호가 존재하지 않습니다");
        }
    }

    public Rank findRank(Lotto other) {
        int count = winningNumberLotto.uniqueNumberSize(other);
        boolean hasBonusNumber = other.contains(bonusNumber);

        if (count == 5) {
            return determineMatchedFiveNumberRank(hasBonusNumber);
        }

        return Rank.find(count);
    }

    private Rank determineMatchedFiveNumberRank(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return Rank.TWO;
        }

        return Rank.THREE;
    }
}
