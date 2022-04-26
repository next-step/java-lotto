package lotto.service;

import java.util.List;
import lotto.enums.Release;
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

  public int statistics(List<Product> products, List<Integer> awardNumberList) {
    Release release = Release.THREE;
    Statistics statistics = new Statistics(release);
    int lotto = release.coincideLotto(products, awardNumberList);
    return release.winningAmount(lotto);
  }

  public List<Integer> getAwardNumberList(String awardNumber) {
    return AwardNumberUtil.getAwadNumberList(awardNumber);
  }
}
