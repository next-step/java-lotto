package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.LottoOutlet;
import lotto.model.ResultLotto;

import java.util.List;

public class LottoService {
    private final ResultLotto resultLotto;
    private static final String INVALID_MANUAL_MESSAGE = "소유한 금액으로는 해당하는 수의 로또를 구매할 수 없습니다";

    public LottoService() {
        this.resultLotto = new ResultLotto();
    }

    public ResultLotto buyLottos(int seedMoney) {
        int lottoCount = LottoOutlet.lottoCount(seedMoney);
        List<Lotto> buyLottos = LottoOutlet.generateLottos(lottoCount);

        resultLotto.recordBuyAutoLottos(buyLottos);
        return resultLotto;
    }

    public ResultLotto checkLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        resultLotto.recordWinningNumbers(LottoNumbers.valueOf(winningNumbers), bonusNumber);

        return resultLotto;
    }

    public int buyManualLotto(int seedMoney, int manualLottoCount, List<List<Integer>> manualLottoNumbers) {
        List<Lotto> buyLottos = LottoOutlet.generateLottos(manualLottoNumbers);
        resultLotto.recordManualLottos(buyLottos);
        return getRemainMoney(seedMoney, manualLottoCount);
    }

    private static int getRemainMoney(int seedMoney, int manualLottoCount) {
        int paidMoney = LottoOutlet.lottoMoney(manualLottoCount);
        int remainMoney = seedMoney - paidMoney;

        if (remainMoney < 0) {
            throw new IllegalArgumentException(INVALID_MANUAL_MESSAGE);
        }

        return remainMoney;
    }
}
