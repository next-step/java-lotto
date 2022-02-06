package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final int MATCHED_BONUS_BALL = 1;
    private static final int NOT_MATCHED_BONUS_BALL = 0;
    private static final LottoCalculator INSTANCE = new LottoCalculator();

    private LottoCalculator() {
    }

    public static LottoCalculator getInstance() {
        return INSTANCE;
    }

    public LottoResult countLotteryNumber(final List<LottoNumber> lotteryNumbers,
        List<LottoNumber> userNumbers, int bonusNumber) {

        return new LottoResult(countNormalSuccessNumber(lotteryNumbers, userNumbers),
            countBonusNumber(userNumbers, bonusNumber));
    }

    private int countNormalSuccessNumber(final List<LottoNumber> lotteryNumbers, List<LottoNumber> userNumbers) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(lotteryNumbers);
        lottoDuplicate.addAll(userNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private int countBonusNumber(List<LottoNumber> userNumbers, int bonusNum) {
        if (userNumbers.contains(bonusNum)) {
            return MATCHED_BONUS_BALL;
        }
        return NOT_MATCHED_BONUS_BALL;
    }
}
