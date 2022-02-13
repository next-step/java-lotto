package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningLotto;

public class LottoCountCalculator {

    private static final LottoCountCalculator INSTANCE = new LottoCountCalculator();

    private LottoCountCalculator() {
    }

    public static LottoCountCalculator getInstance() {
        return INSTANCE;
    }


    public List<Ranking> countLotteryNumbers(List<Lotto> userNumbers,
        WinningLotto winningLotto) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto userNumber : userNumbers) {
            rankings.add(countLotteryNumber(userNumber, winningLotto));
        }
        return rankings;
    }

    public Ranking countLotteryNumber(Lotto userNumbers,
        WinningLotto winningLotto) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers, winningLotto.getLottoNumbers());
        int bonusSuccessCount = countBonusNumber(userNumbers, winningLotto.getBonusNumber());

        return Ranking.getRanking(normalSuccessCount, bonusSuccessCount);
    }

    private int countNormalSuccessNumber(Lotto userNumbers, Lotto lotteryNumbers) {
        return lotteryNumbers.countSameNumber(userNumbers);
    }

    private int countBonusNumber(Lotto userNumbers, LottoNumber bonusNum) {
        int bonusSuccessCount = 0;
        if (userNumbers.contains(bonusNum)) {
            bonusSuccessCount++;
        }
        return bonusSuccessCount;
    }
}
