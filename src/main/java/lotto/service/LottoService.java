package lotto.service;

import java.util.List;
import lotto.enums.Release;
import lotto.model.Guest;
import lotto.model.Product;
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

//  public int statistics(List<Product> products, List<Integer> awardNumberList) {
//    for (Release release : Release.values()) {
//
//    }
//    Statistics statistics = new Statistics()
//    return Release.THREE.coincideLotto(products, awardNumberList);
//  }

  public List<Integer> getAwardNumberList(String awardNumber) {
    return AwardNumberUtil.getAwadNumberList(awardNumber);
  }
}
