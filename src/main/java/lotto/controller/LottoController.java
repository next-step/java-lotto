package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.LotteryResults;
import lotto.model.Lotto;
import lotto.model.Store;
import lotto.service.LottoService;
import lotto.view.InputTable;
import lotto.view.OutputTable;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        OutputTable.inputPurchaseAmount();
        long haveMoney = InputTable.inputHaveMoney();

        List<Lotto> lottoProducts = visit(new Guest(haveMoney), new Store());
        OutputTable.buyThings(lottoProducts.size());
        OutputTable.printProductInfos(lottoProducts);

        OutputTable.lastWeekAwardNumber();
        Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());

        OutputTable.getBonus();
        int bonus = insertBonusNumber(InputTable.inputBonusNumber());
        holdingLotteryTickets(lottoProducts, winnerLotto, bonus);
        OutputTable.resultStatisticsMessage();
        OutputTable.resultStatistics(LotteryResults.getLotteryResult());
        OutputTable.printYield(yieldCalculate(haveMoney), 1);
    }

    public List<Lotto> visit(Guest guest, Store store) {
        return lottoService.visit(guest, store);
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
