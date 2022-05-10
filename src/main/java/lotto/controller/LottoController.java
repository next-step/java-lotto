package lotto.controller;

import lotto.model.Guest;
import lotto.model.LotteryResults;
import lotto.model.Lotto;
import lotto.model.Store;
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
        OutputTable.inputPurchaseAmount();
        long haveMoney = InputTable.inputHaveMoney();
        OutputTable.boughtManualLottoCountMessage();
        int manalLottoCount = InputTable.inputManualCount();

        OutputTable.boughtManualLottoMessage();
        Store store = new Store(manalLottoCount);
        List<Lotto> manualLottos = store.manualLottos(InputTable.inputManualLotto(manalLottoCount));
        List<Lotto> lottoProducts = boughtAutoLotto(new Guest(haveMoney), store);
        List<Lotto> boughtAllLottos = store.boughtAllLottos(manualLottos, lottoProducts);
        OutputTable.buyThings(manalLottoCount, lottoProducts.size());
        OutputTable.printProductInfos(lottoProducts);

        OutputTable.lastWeekAwardNumber();
        Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());

        OutputTable.getBonus();
        int bonus = insertBonusNumber(InputTable.inputBonusNumber());
        holdingLotteryTickets(boughtAllLottos, winnerLotto, bonus);
        OutputTable.resultStatisticsMessage();
        OutputTable.resultStatistics(LotteryResults.getLotteryResult());
        OutputTable.printYield(yieldCalculate(haveMoney), 1);
    }

    public List<Lotto> boughtAutoLotto(Guest guest, Store store) {
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
