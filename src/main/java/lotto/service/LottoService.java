package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.Grade;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Statistics;
import lotto.model.Store;
import lotto.util.AwardNumberUtil;

public class LottoService {

  public Guest visit(int money, Store store) {
    return new Guest(money, store);
  }

  public int productCount(Guest guest) {
    return guest.boughtLottoCount();
  }

  public List<Product> purchaseProduct(Guest guest) {
    return guest.haveLottoList();
  }

  public List<Statistics> getStatistics(List<Product> products, List<Integer> awardNumberList) {
    List<Statistics> statistics = new ArrayList<>();
    for (Grade grade : Grade.values()) {
      Statistics statistic = new Statistics(grade).awardCount(products, awardNumberList);
      statistics.add(statistic);
    }
    return statistics;
  }

  public List<Integer> getAwardNumberList(String awardNumber) {
    return AwardNumberUtil.getAwadNumberList(awardNumber);
  }
}
