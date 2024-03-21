package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
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

    public StatisticsOfLottos statistics(WinningNumbers winningNumbers, PurchaseAmountOfMoney purchaseAmountOfMoney) {
        ResultOfLottos resultOfLottos = resultOfLottos(winningNumbers);
        double rateOfReturn = purchaseAmountOfMoney.rateOfReturn(resultOfLottos.totalWinningMoney());

        return StatisticsOfLottos.newLottoResult(resultOfLottos, rateOfReturn);
    }

    private ResultOfLottos resultOfLottos(WinningNumbers winningNumbers) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();
        lottos.forEach(lotto -> resultOfLottos.increaseNumberOfMatchCount(lotto.countOfMatch(winningNumbers)));

        return resultOfLottos;
    }
}
