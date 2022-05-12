package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputTable;
import lotto.view.OutputTable;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        long haveMoney = InputTable.inputHaveMoney();
        Guest guest = new Guest(haveMoney);
        int manalLottoCount = InputTable.inputManualCount();
        Store store = new Store(manalLottoCount);
        Lottos manualLottos = store.manualLottos(InputTable.inputManualLotto(manalLottoCount));
        Lottos autoLottos = boughtAutoLotto(guest, store);
        Lottos boughtAllLottos = Lottos.plus(manualLottos, autoLottos);
        OutputTable.buyThings(manalLottoCount, autoLottos.getLottos().size());
        OutputTable.printProductInfos(boughtAllLottos.getLottos());
        Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());
        int bonus = insertBonusNumber(InputTable.inputBonusNumber());
        holdingLotteryTickets(boughtAllLottos.getLottos(), winnerLotto, bonus);
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
