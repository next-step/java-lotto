package lotto.controller;

import java.util.List;
import lotto.dto.WinningResultDto;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Store;
import lotto.service.LottoService;
import lotto.view.OutputTable;

public class LottoController {

  private final LottoService lottoService;

  public LottoController(LottoService lottoService) {
    this.lottoService = lottoService;
  }

  public static void main(String[] args) {
    OutputTable.run();
  }

  public Guest visit(Guest guest, Store store) {
    return lottoService.visit(guest, store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
    return lottoService.insertWinnerNumber(winnerNumber);
  }

  public List<WinningResultDto> histories(List<Product> products, Product winProduct) {
    return lottoService.histories(products, winProduct);
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
