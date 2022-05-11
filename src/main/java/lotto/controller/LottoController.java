package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputTable;
import lotto.view.OutputTable;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        long haveMoney = InputTable.inputHaveMoney();
        int manalLottoCount = InputTable.inputManualCount();
        Store store = new Store(manalLottoCount);
        Lottos manualLottos = store.manualLottos(InputTable.inputManualLotto(manalLottoCount));
        Lottos autoLottos = boughtAutoLotto(new Guest(haveMoney), store);
        Lottos boughtAllLottos = Lottos.plus(manualLottos, autoLottos);
        OutputTable.buyThings(manalLottoCount, autoLottos.getLottos().size());
        OutputTable.printProductInfos(autoLottos.getLottos());
        Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());
        int bonus = insertBonusNumber(InputTable.inputBonusNumber());
        holdingLotteryTickets(boughtAllLottos.getLottos(), winnerLotto, bonus);
        OutputTable.resultStatisticsMessage();
        OutputTable.resultStatistics(LotteryResults.getLotteryResult());
        OutputTable.printYield(yieldCalculate(haveMoney), 1);
    }

    public Lottos boughtAutoLotto(Guest guest, Store store) {
        return lottoService.boughtAutoLotto(guest, store);
    }

    public void holdingLotteryTickets(List<Lotto> lottoProducts, Lotto winnerLotto, int bonus) {
        lottoService.holdingLotteryTickets(lottoProducts, winnerLotto, bonus);
    }


    public Lotto insertWinnerNumber(String winnerNumber) {
        return lottoService.insertWinnerNumber(winnerNumber);
    }

    public Integer insertBonusNumber(int bonus) {
        return lottoService.insertBonusNumber(bonus);
    }

    public double yieldCalculate(long money) {
        return lottoService.yieldCalculate(money);
    }

}
