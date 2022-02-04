package lotto.service;

import lotto.domain.LottoCountResult;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoCountCalculator {


    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {
    }

    public LottoCountResult countLotteryNumber(LottoNumbers userNumbers,
        LottoNumbers lottoNumbers, LottoNumber bonusNum) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers, lottoNumbers);
        int bonusSuccessCount = countBonusNumber(userNumbers, bonusNum);

        return new LottoCountResult(normalSuccessCount, bonusSuccessCount);
    }

    private int countNormalSuccessNumber(LottoNumbers userNumbers, LottoNumbers lotteryNumbers) {
        return lotteryNumbers.countSameNumber(userNumbers);
    }

    private int countBonusNumber(LottoNumbers userNumbers, LottoNumber bonusNum) {
        int bonusSuccessCount = 0;
        if (userNumbers.contains(bonusNum)) {
            bonusSuccessCount++;
        }
        return bonusSuccessCount;
    }

    public static LottoCountCalculator getInstance() {
        return INSTANCE;
    }
}