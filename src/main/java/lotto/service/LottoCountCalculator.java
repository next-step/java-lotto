package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;

public class LottoCountCalculator {

    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {
    }

    public static LottoCountCalculator getInstance() {
        return INSTANCE;
    }


    public List<Ranking> countLotteryNumbers(List<LottoNumbers> userNumbers,
        WinningLotto winningLotto) {
        List<Ranking> rankings = new ArrayList<>();
        for (LottoNumbers userNumber : userNumbers) {
            rankings.add(countLotteryNumber(userNumber, winningLotto));
        }
        return rankings;
    }

    public Ranking countLotteryNumber(LottoNumbers userNumbers,
        WinningLotto winningLotto) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers, winningLotto.getLottoNumbers());
        int bonusSuccessCount = countBonusNumber(userNumbers, winningLotto.getBonusNumber());

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
}
