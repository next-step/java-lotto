package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final boolean MATCHED_BONUS_BALL = true;
    private static final boolean NOT_MATCHED_BONUS_BALL = false;
    private static final LottoCalculator INSTANCE = new LottoCalculator();

    private LottoCalculator() {
    }

    public static LottoCalculator getInstance() {
        return INSTANCE;
    }

    public LottoResult countLotteryNumber(final List<LottoNumber> winningNumbers,
        List<LottoNumber> userNumbers, LottoNumber bonusNumber) {

        return new LottoResult(countNormalSuccessNumber(winningNumbers, userNumbers),
            countBonusNumber(userNumbers, bonusNumber));
    }

    private int countNormalSuccessNumber(final List<LottoNumber> winningNumbers, List<LottoNumber> userNumbers) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(winningNumbers);
        lottoDuplicate.addAll(userNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private boolean countBonusNumber(final List<LottoNumber> userNumbers, final LottoNumber bonusNumber) {
        if (userNumbers.contains(bonusNumber)) {
            return MATCHED_BONUS_BALL;
        }
        return NOT_MATCHED_BONUS_BALL;
    }
}
