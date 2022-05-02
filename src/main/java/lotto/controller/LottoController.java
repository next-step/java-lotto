package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.WinningResultDto;
import lotto.enums.Grade;
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
    List<Lotto> lottoProducts = visit(new Guest(haveMoney), new Store()).hasAllLotto();
    OutputTable.buyThings(lottoProducts.size());
    OutputTable.printProductInfos(lottoProducts);
    OutputTable.lastWeekAwardNumber();
    Lotto winnerLotto = insertWinnerNumber(InputTable.inputAwardNumber());
    OutputTable.resultStatisticsMessage();
    List<WinningResultDto> histories = histories(lottoProducts, winnerLotto);
    OutputTable.resultStatistics(histories);
    double percent = yieldCalculate(haveMoney, allAddReward(histories));
    OutputTable.printYield(percent, isStandard(percent));
  }

  private List<WinningResultDto> histories(List<Lotto> lottoProducts, Lotto winnerLotto) {
    List<Lotto> lotteryTickets = lottoService.allLotteryTickets(lottoProducts, winnerLotto);
    return lottoService.histories(lotteryTickets)
        .stream()
        .filter(grade -> grade.getGrade() != Grade.NONE)
        .collect(Collectors.toList());
  }


  public Guest visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public Lotto insertWinnerNumber(String winnerNumber) {
    return lottoService.insertWinnerNumber(winnerNumber);
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
