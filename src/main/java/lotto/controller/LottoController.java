package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.History;
import lotto.model.Product;
import lotto.model.Statistics;
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
    int haveMoney = InputTable.inputHaveMoney();
    List<Product> products = visit(new Guest(haveMoney), new Store()).hasAllLotto();
    OutputTable.buyThings(products.size());
    OutputTable.printProductInfos(products);
    OutputTable.lastWeekAwardNumber();
    Product winnerProduct = insertWinnerNumber(InputTable.inputAwardNumber());
    OutputTable.resultStatisticsMessage();
    List<History> histories = histories(products, winnerProduct);
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

  public List<History> histories(List<Product> products, Product winProduct) {
    return lottoService.histories(products, winProduct);
  }

  public Long allAddReward(List<History> histories) {
    return lottoService.allAddReward(histories);
  }

  public double yieldCalculate(int money, Long reward) {
    return lottoService.yieldCalculate(money, reward);
  }

  public boolean isStandard(double percent) {
    return percent > 1;
  }

}
