package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.LottoCountResult;

public class LottoCountCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {}

    public LottoCountResult countLotteryNumber(final List<Integer> lotteryNumbers, List<Integer> userNumbers, int bonusNum) {
        int normalSuccessCount = countNormalSuccessNumber(lotteryNumbers, userNumbers);
        int bonusSuccessCount = countBonusNumber(userNumbers, bonusNum);

        return new LottoCountResult(normalSuccessCount, bonusSuccessCount);
    }

    private int countNormalSuccessNumber(final List<Integer> lotteryNumbers, List<Integer> userNumbers){
        Set<Integer> lottoDuplicate = new HashSet<>(lotteryNumbers);
        lottoDuplicate.addAll(userNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private int countBonusNumber(List<Integer> userNumbers, int bonusNum){
        int bonusSuccessCount = 0;
        if(userNumbers.contains(bonusNum)){
            bonusSuccessCount++;
        }
        return bonusSuccessCount;
    }

    public static LottoCountCalculator getInstance() {
        return INSTANCE;
    }
}