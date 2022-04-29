package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.dto.HistoryDto;
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
    return new Product(new HashSet<>(AwardNumberUtil.getAwadNumberList(winnerNumber)));
  }

  public List<HistoryDto> histories(List<Product> products, Product winProduct) {
    List<HistoryDto> histories = new ArrayList<>();
    Statistics statistics = new Statistics();
    for (Grade grade : Grade.values()) {
      int result = statistics.result(grade, products, winProduct);
      statistics = statistics.winReward(grade, result);
      histories.add(new HistoryDto(grade, result));
    }
    return histories;
  }

  public Long allAddReward(List<HistoryDto> histories) {
    long result = 0L;
    for (HistoryDto history : histories) {
      result += (history.getGrade().getAwardPrice() * history.getCount());
    }
    return result;
  }

  public double yieldCalculate(Long money, Long reward) {
    return (double) reward / money;
  }
}
