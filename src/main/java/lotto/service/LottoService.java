package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoOutlet;
import lotto.model.ResultLotto;

import java.util.List;

public class LottoService {
    private final ResultLotto resultLotto;

    public LottoService() {
        this.resultLotto = new ResultLotto();
    }

    public ResultLotto buyLottos(int seedMoney) {
        int lottoCount = LottoOutlet.lottoCount(seedMoney);
        List<Lotto> buyLottos = LottoOutlet.generateLottos(lottoCount);

        resultLotto.recordBuyLottos(buyLottos);
        return resultLotto;
    }

    public ResultLotto checkLottoResult(List<Integer> winningNumbers) {
        resultLotto.recordWinningNumbers(winningNumbers);

        return resultLotto;
    }
}
