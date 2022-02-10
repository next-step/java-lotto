package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private static final int STANDARD_NUMBER = 12;
    private static final boolean MATCHED_BONUS_BALL = true;
    private static final boolean NOT_MATCHED_BONUS_BALL = false;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<LottoNumber> winningNumbers, final LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public Ranking matchLotto(final Lotto lotto) {
        final int normalNumberMatchCount = countNormalSuccessNumber(winningNumbers, lotto);
        final boolean isMatchedBonusNumber = countBonusNumber(lotto, bonusBall);
        return Ranking.judgeRanking(normalNumberMatchCount, isMatchedBonusNumber);
    }

    private int countNormalSuccessNumber(final List<LottoNumber> winningNumbers, Lotto lotto) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(winningNumbers);
        lottoDuplicate.addAll(lotto.getLottoNumbers());
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private boolean countBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            return MATCHED_BONUS_BALL;
        }
        return NOT_MATCHED_BONUS_BALL;
    }
}
