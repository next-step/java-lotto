package lotto.controller;

import java.util.List;
import lotto.dto.WinningResultDto;
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
    List<Lotto> lottos = visit(new Guest(haveMoney), new Store()).hasAllLotto();
    OutputTable.buyThings(lottos.size());
    OutputTable.printProductInfos(lottos);
    OutputTable.lastWeekAwardNumber();
    Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());
    OutputTable.resultStatisticsMessage();
    List<WinningResultDto> histories = histories(lottos, winnerLotto);
    OutputTable.resultStatistics(histories);
    double percent = yieldCalculate(haveMoney, allAddReward(histories));
    OutputTable.printYield(percent, isStandard(percent));
  }


  public Guest visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public Lotto insertWinnerNumber(String winnerNumber) {
    return lottoService.insertWinnerNumber(winnerNumber);
  }

  public List<WinningResultDto> histories(List<Lotto> lottos, Lotto winLotto) {
    return lottoService.histories(lottos, winLotto);
  }

  public Long allAddReward(List<WinningResultDto> histories) {
    return lottoService.allAddReward(histories);
  }

  public double yieldCalculate(Long money, Long reward) {
    return lottoService.yieldCalculate(money, reward);
  }

  public boolean isStandard(double percent) {
    return percent > 1;
  }

}
