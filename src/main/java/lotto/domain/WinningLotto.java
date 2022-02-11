package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private static final int STANDARD_NUMBER = 12;

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(final Lotto winningNumbers, final LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public Ranking matchLotto(final Lotto lotto) {
        final int normalNumberMatchCount = countNormalSuccessNumber(lotto);
        final boolean isMatchedBonusNumber = countBonusNumber(lotto);
        return Ranking.judgeRanking(normalNumberMatchCount, isMatchedBonusNumber);
    }

    private int countNormalSuccessNumber(Lotto lotto) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(winningNumbers.getLottoNumbers());
        lottoDuplicate.addAll(lotto.getLottoNumbers());
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private boolean countBonusNumber(final Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusBall);
    }
}
