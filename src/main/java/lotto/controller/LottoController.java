package lotto.controller;

import java.util.List;
import lotto.dto.HistoryDto;
import lotto.model.Guest;
import lotto.model.Product;
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
    List<Product> products = visit(new Guest(haveMoney), new Store()).hasAllLotto();
    OutputTable.buyThings(products.size());
    OutputTable.printProductInfos(products);
    OutputTable.lastWeekAwardNumber();
    Product winnerProduct = insertWinnerNumber(InputTable.inputAwardNumber());
    OutputTable.resultStatisticsMessage();
    List<HistoryDto> histories = histories(products, winnerProduct);
    OutputTable.resultStatistics(histories);
    double percent = yieldCalculate(haveMoney, allAddReward(histories));
    OutputTable.printYield(percent, isStandard(percent));
  }

  public Guest visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
    return lottoService.insertWinnerNumber(winnerNumber);
  }

  public List<HistoryDto> histories(List<Product> products, Product winProduct) {
    return lottoService.histories(products, winProduct);
  }

  public Long allAddReward(List<HistoryDto> histories) {
    return lottoService.allAddReward(histories);
  }

  public double yieldCalculate(Long money, Long reward) {
    return lottoService.yieldCalculate(money, reward);
  }

  public boolean isStandard(double percent) {
    return percent > 1;
  }

}
