package lotto.domain.lotto;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos valueOf(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public StatisticsOfLottos statistics(WinningNumbers winningNumbers, BonusNumber bonusNumber, PurchaseAmountOfMoney purchaseAmountOfMoney) {
        ResultOfLottos resultOfLottos = resultOfLottos(winningNumbers, bonusNumber);
        double rateOfReturn = purchaseAmountOfMoney.rateOfReturn(resultOfLottos.totalWinningMoney());

        return StatisticsOfLottos.newLottoResult(resultOfLottos, rateOfReturn);
    }

    private ResultOfLottos resultOfLottos(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        lottos.forEach(lotto -> {
            int matchCount = lotto.countOfMatch(winningNumbers);
            boolean isBonusMatched = bonusNumber.isMatched(lotto.lottoNumbers());
            resultOfLottos.increaseNumberOfMatchCount(Rank.findRank(matchCount, isBonusMatched));
        });

        return resultOfLottos;
    }
}
