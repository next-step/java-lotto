package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.History;
import lotto.model.Product;
import lotto.model.Statistics;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

  public Product insertWinnerNumber(String winnerNumber) {
    return new Product(AwardNumberUtil.getAwadNumberList(winnerNumber));
  }

  public List<History> histories(List<Product> products, Product winProduct) {
    List<History> histories = new ArrayList<>();
    Statistics statistics = new Statistics();
    for (Grade grade : Grade.values()) {
      int result = statistics.result(grade, products, winProduct);
      statistics = statistics.winReward(grade, result);
      histories.add(new History(grade, result));
    }
    return histories;
  }

  public Long allAddReward(List<History> histories) {
    long result = 0L;
    for (History history : histories) {
      result += ((long) history.getGrade().getAwardPrice() * history.getCount());
    }
    return result;
  }

  public double yieldCalculate(int money, Long reward) {
    return (double) reward / money;
  }
}
