package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResultDto;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Statistics;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
    return Product.from(AwardNumberUtil.getAwadNumberList(winnerNumber));
  }

  public List<WinningResultDto> histories(List<Product> products, Product winProduct) {
    List<WinningResultDto> histories = new ArrayList<>();
    Statistics statistics = new Statistics();
    for (Grade grade : Grade.values()) {
      int result = statistics.result(grade, products, winProduct);
      statistics = statistics.winReward(grade, result);
      histories.add(new WinningResultDto(grade, result));
    }
    return histories;
  }

  public Long allAddReward(List<WinningResultDto> histories) {
    long result = 0L;
    for (WinningResultDto history : histories) {
      result += (history.getGrade().getAwardPrice() * history.getCount());
    }
    return result;
  }

  public double yieldCalculate(Long money, Long reward) {
    return (double) reward / money;
  }
}
