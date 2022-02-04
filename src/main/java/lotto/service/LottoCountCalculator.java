package lotto.service;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.LottoCountResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoCountCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {}

    public LottoCountResult countLotteryNumber(LottoNumbers lotteryNumbers, LottoNumbers userNumbers, LottoNumber bonusNum) {
        int normalSuccessCount = countNormalSuccessNumber(lotteryNumbers, userNumbers);
        int bonusSuccessCount = countBonusNumber(userNumbers, bonusNum);

        return new LottoCountResult(normalSuccessCount, bonusSuccessCount);
    }

    private int countNormalSuccessNumber(LottoNumbers lotteryNumbers, LottoNumbers userNumbers){
        Set<LottoNumber> lottoDuplicate = new HashSet<>(lotteryNumbers.getNumbers());
        lottoDuplicate.addAll(userNumbers.getNumbers());
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    private int countBonusNumber(LottoNumbers userNumbers, LottoNumber bonusNum){
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