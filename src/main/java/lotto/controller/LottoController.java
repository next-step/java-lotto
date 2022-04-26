package lotto.controller;

import java.util.List;
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
    Integer haveMoney = InputTable.inputHaveMoney();
    Guest guest = visit(haveMoney, new Store());
    OutputTable.buyThings(productCount(guest));
    List<Product> products = purchaseProduct(guest);
    OutputTable.printProductInfos(products);
    OutputTable.lastWeekAwardNumber();
    List<Integer> awardNumberList = getAwardNumberList(InputTable.inputAwardNumber());
    OutputTable.resultStatistics();
    OutputTable.printStatistics(statistics(products, awardNumberList));
  }

  public Guest visit(Integer money, Store store) {
    return lottoService.visit(money, store);
  }

  public Integer productCount(Guest guest) {
    return lottoService.productCount(guest);
  }

  public List<Product> purchaseProduct(Guest guest) {
    return lottoService.purchaseProduct(guest);
  }

  public List<Integer> getAwardNumberList(String awardNumber) {
    return lottoService.getAwardNumberList(awardNumber);
  }

  public int statistics(List<Product> products, List<Integer> awardNumberList) {
    return lottoService.statistics(products, awardNumberList);
  }
}
