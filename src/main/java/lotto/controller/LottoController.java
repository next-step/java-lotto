package lotto.controller;

import java.util.List;
import lotto.model.Guest;
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

    List<Lotto> lottoProducts = visit(new Guest(haveMoney),
        new Store()).hasAllLotto();

    OutputTable.buyThings(lottoProducts.size());
    OutputTable.printProductInfos(lottoProducts);

    OutputTable.lastWeekAwardNumber();
    Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());

    OutputTable.getBonus();
    int bonus = insertBonusNumber(InputTable.inputBonusNumber());

    OutputTable.resultStatisticsMessage();

//    List<WinningResultDto> histories = histories(
//        allLotteryTickets(lottoProducts, winnerLotto, bonus));
//    OutputTable.resultStatistics(histories);
//
//    OutputTable.printYield(yieldCalculate(haveMoney, allAddReward(histories)), 1);

  }

  public Guest visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public void allLotteryTickets(List<Lotto> lottoProducts, Lotto winnerLotto, int bonus) {
    lottoService.holdingLotteryTickets(lottoProducts, winnerLotto, bonus);
  }

//  private List<WinningResultDto> histories(List<Lotto> lotteryTickets) {
//    return lottoService.histories(lotteryTickets);
//  }


  public Lotto insertWinnerNumber(String winnerNumber) {
    return lottoService.insertWinnerNumber(winnerNumber);
  }

  public Integer insertBonusNumber(int bonus) {
    return lottoService.insertBonusNumber(bonus);
  }

//  public long allAddReward(List<WinningResultDto> histories) {
//    return lottoService.allAddReward(histories);
//  }

  public double yieldCalculate(Long money, Long reward) {
    return lottoService.yieldCalculate(money, reward);
  }


}
