package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningAndBonusNumbers;

import java.util.Collections;
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
        return Collections.unmodifiableList(lottos);
    }

    public StatisticsOfLottos statistics(WinningAndBonusNumbers winningAndBonusNumbers, PurchaseAmountOfMoney purchaseAmountOfMoney) {
        ResultOfLottos resultOfLottos = resultOfLottos(winningAndBonusNumbers);
        double rateOfReturn = purchaseAmountOfMoney.rateOfReturn(resultOfLottos.totalWinningMoney());

        return StatisticsOfLottos.newLottoResult(resultOfLottos, rateOfReturn);
    }

    private ResultOfLottos resultOfLottos(WinningAndBonusNumbers winningAndBonusNumbers) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        lottos.forEach(lotto -> resultOfLottos.increaseNumberOfMatchCount(winningAndBonusNumbers.rankOfLotto(lotto)));

        return resultOfLottos;
    }
}
