package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoResult;

public class LottoCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final LottoCalculator INSTANCE = new LottoCalculator();

    private LottoCalculator() {
    }

    public static LottoCalculator getInstance() {
        return INSTANCE;
    }

    public LottoResult countLotteryNumber(final List<Integer> lotteryNumbers,
        List<Integer> userNumbers, int bonusNumber) {
        int normalSuccessCount = countNormalSuccessNumber(lotteryNumbers, userNumbers);
        int bonusSuccessCount = countBonusNumber(userNumbers, bonusNumber);

        return new LottoResult(normalSuccessCount, bonusSuccessCount);
    }

    private int countNormalSuccessNumber(final List<Integer> lotteryNumbers,
        List<Integer> userNumbers) {
        Set<Integer> lottoDuplicate = new HashSet<>(lotteryNumbers);
        lottoDuplicate.addAll(userNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private int countBonusNumber(List<Integer> userNumbers, int bonusNum) {
        int bonusSuccessCount = 0;
        if (userNumbers.contains(bonusNum)) {
            bonusSuccessCount++;
        }
        return bonusSuccessCount;
    }
}
