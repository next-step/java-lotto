package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;

public class LottoCountCalculator {


    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {
    }

    public List<Ranking> countLotteryNumbers(List<LottoNumbers> userNumbers,
        LottoNumbers lottoNumbers, LottoNumber bonusNum) {
        List<Ranking> rankings = new ArrayList<>();
        for (LottoNumbers userNumber : userNumbers) {
            rankings.add(countLotteryNumber(userNumber, lottoNumbers, bonusNum));
        }
        return rankings;
    }

    public Ranking countLotteryNumber(LottoNumbers userNumbers,
        LottoNumbers lottoNumbers, LottoNumber bonusNum) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers, lottoNumbers);
        int bonusSuccessCount = countBonusNumber(userNumbers, bonusNum);

        return Ranking.getRanking(normalSuccessCount, bonusSuccessCount);
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