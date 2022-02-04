package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoResult;

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

    public LottoResult countLotteryNumber(final List<Integer> lotteryNumbers,
        List<Integer> userNumbers, int bonusNumber) {

        return new LottoResult(countNormalSuccessNumber(lotteryNumbers, userNumbers),
            countBonusNumber(userNumbers, bonusNumber));
    }

    private int countNormalSuccessNumber(final List<Integer> lotteryNumbers,
        List<Integer> userNumbers) {
        Set<Integer> lottoDuplicate = new HashSet<>(lotteryNumbers);
        lottoDuplicate.addAll(userNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private int countBonusNumber(List<Integer> userNumbers, int bonusNum) {
        if (userNumbers.contains(bonusNum)) {
            return MATCHED_BONUS_BALL;
        }
        return NOT_MATCHED_BONUS_BALL;
    }
}
