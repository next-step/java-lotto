package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoCenter {

    private static Cash cash;
    private WinningLotto winningLotto;
    private Result result;

    public LottoCenter() {
    }

    public LottoCenter(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Lotto> manualBuyLotto(Cash cash, List<Lotto> manualLottos) {
        LottoCenter.cash = cash;
        if (manualLottos == null || manualLottos.isEmpty()) {
            return generateTicket(cash);
        }
        Cash autoCash = cash.autoBuy(manualLottos);
        List<Lotto> lottos = generateTicket(autoCash);
        manualLottos.addAll(lottos);

        return manualLottos;
    }

    private List<Lotto> generateTicket(Cash cash) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cash.count(); i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Result matchWinningNumbers(List<Lotto> lottos) {
        Result checkedResult = new Result();
        for (Lotto lotto : lottos) {
            checkedResult.add(winningLotto.matchRank(lotto));
        }
        this.result = checkedResult;
        return this.result;
    }

    public List<Integer> checkWinningResult() {
        List<Integer> statistic = new ArrayList<>();
        for (Rank value : values()) {
            int count = result.countRank(value);
            statistic.add(count);
        }
        return statistic;
    }

    public float checkWinningRate() {
        int sum = 0;
        for (Rank value : values()) {
            int count = result.countRank(value);
            sum = sum + count * value.getWinningMoney();
        }
        return cash.winningRate(sum);
    }
}
