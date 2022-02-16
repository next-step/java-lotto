package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Ranking;
import lotto.domain.Rankings;
import lotto.domain.WinningLotto;

public class LottoRankingCalculator {

    private static final LottoRankingCalculator INSTANCE = new LottoRankingCalculator();

    private LottoRankingCalculator() {
    }

    public static LottoRankingCalculator getInstance() {
        return INSTANCE;
    }


    public Rankings countLotteryNumbers(List<Lotto> userNumbers,
        WinningLotto winningLotto) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto userNumber : userNumbers) {
            rankings.add(countLotteryNumber(userNumber, winningLotto));
        }
        return new Rankings(rankings);
    }

    public Ranking countLotteryNumber(Lotto userNumbers,
        WinningLotto winningLotto) {
        int normalSuccessCount = countNormalSuccessNumber(userNumbers,
            winningLotto.getLottoNumbers());
        boolean bonusSuccess = countBonusNumber(userNumbers, winningLotto.getBonusNumber());

        return Ranking.of(normalSuccessCount, bonusSuccess);
    }

    private int countNormalSuccessNumber(Lotto userNumbers, Lotto lotteryNumbers) {
        return lotteryNumbers.countSameNumber(userNumbers);
    }

    private boolean countBonusNumber(Lotto userNumbers, LottoNumber bonusNum) {
        return userNumbers.contains(bonusNum);
    }
}
