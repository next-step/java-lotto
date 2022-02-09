package lotto;

import java.util.Map;
import lotto.domain.LottoRaffle;
import lotto.domain.LottoResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.count.Count;
import lotto.domain.lotto.count.ManualCount;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Numbers;
import lotto.domain.money.Money;

public class LottoGame {

    public Count calculateLottoCount(Money money) {
        return new Count(money.getValue() / 1000);
    }

    public Lottos generateLottos(int lottoCount) {
        return new Lottos(lottoCount);
    }

    public Map<LottoResult, Integer> getResults(Lottos lottos, Numbers winningNumbers, BonusNumber bonusNumber) {
        final LottoRaffle lottoRaffle = new LottoRaffle(new WinningLotto(winningNumbers, bonusNumber));
        for (Lotto lotto : lottos.getLottos()) {
            lottoRaffle.compareLotto(lotto);
        }
        return lottoRaffle.getResults();
    }

    public Count calculateAutoCount(Count totalCount, ManualCount manualCount) {
        return new Count(totalCount.getValue() - manualCount.getCountValue());
    }
}
