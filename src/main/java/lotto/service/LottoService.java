package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoOutlet;
import lotto.model.ResultLotto;

import java.util.List;

public class LottoService {
    public ResultLotto youOnlyLiveOnce(int seedMoney) {
        int lottoCount = LottoOutlet.lottoCount(seedMoney);
        List<Lotto> buyLottos = LottoOutlet.generateLottos(lottoCount);
        int totalWinningAmount = LottoOutlet.getWinnings(buyLottos, List.of(11,12,13,4,5,6));

        return new ResultLotto(seedMoney, buyLottos, totalWinningAmount);
    }
}
