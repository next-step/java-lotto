package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {

    private static final int STANDARD_NUMBER = 12;
    private static final boolean MATCHED_BONUS_BALL = true;
    private static final boolean NOT_MATCHED_BONUS_BALL = false;

    private int normalSuccessCount;
    private boolean bonusSuccessCount;

    public LottoResult(final int normalSuccessCount, final boolean bonusSuccessCount) {
        this.normalSuccessCount = normalSuccessCount;
        this.bonusSuccessCount = bonusSuccessCount;
    }

    public LottoResult countLotteryNumber(final List<LottoNumber> winningNumbers,
        List<LottoNumber> userNumbers, LottoNumber bonusNumber) {

        countNormalSuccessNumber(winningNumbers, userNumbers);
        countBonusNumber(userNumbers, bonusNumber);
        return this;
    }

    private void countNormalSuccessNumber(final List<LottoNumber> winningNumbers,
        List<LottoNumber> userNumbers) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(winningNumbers);
        lottoDuplicate.addAll(userNumbers);
        normalSuccessCount = STANDARD_NUMBER - lottoDuplicate.size();
    }

    private void countBonusNumber(final List<LottoNumber> userNumbers,
        final LottoNumber bonusNumber) {
        if (userNumbers.contains(bonusNumber)) {
            bonusSuccessCount = MATCHED_BONUS_BALL;
            return;
        }
        bonusSuccessCount = NOT_MATCHED_BONUS_BALL;
    }

    public boolean getBonusSuccessCount() {
        return bonusSuccessCount;
    }

    public int getNormalSuccessCount() {
        return normalSuccessCount;
    }
}
