package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {

    private static final int STANDARD_NUMBER = 12;
    private static final boolean MATCHED_BONUS_BALL = true;
    private static final boolean NOT_MATCHED_BONUS_BALL = false;

    private int normalNumberMatchCount;
    private boolean isBonusNumberMatch;

    public LottoResult(final int normalNumberMatchCount, final boolean isBonusNumberMatch) {
        this.normalNumberMatchCount = normalNumberMatchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
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
        normalNumberMatchCount = STANDARD_NUMBER - lottoDuplicate.size();
    }

    private void countBonusNumber(final List<LottoNumber> userNumbers,
        final LottoNumber bonusNumber) {
        if (userNumbers.contains(bonusNumber)) {
            isBonusNumberMatch = MATCHED_BONUS_BALL;
            return;
        }
        isBonusNumberMatch = NOT_MATCHED_BONUS_BALL;
    }

    public boolean getBonusNumberMatch() {
        return isBonusNumberMatch;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }
}
