package lotto.controller;

import calculator.util.StringUtil;
import java.util.List;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Store;
import lotto.service.LottoService;
import lotto.util.AwardNumberUtil;
import lotto.view.InputTable;
import lotto.view.OutputTable;

public class LottoController {

  private final LottoService lottoService;

  public LottoController(LottoService lottoService) {
    this.lottoService = lottoService;
  }

  public void run() {
    OutputTable.inputPurchaseAmount();
    Integer haveMoney = InputTable.inputHaveMoney();
    List<Product> products = visit(new Guest(haveMoney), new Store());
    OutputTable.buyThings(products.size());
    OutputTable.printProductInfos(products);
    OutputTable.lastWeekAwardNumber();
    Product winnerProduct = insertWinnerNumber(InputTable.inputAwardNumber());
    OutputTable.resultStatistics();
  }

  public List<Product> visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
     return lottoService.insertWinnerNumber(winnerNumber);
  }




}
