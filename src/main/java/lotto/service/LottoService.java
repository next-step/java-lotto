package lotto.service;

import java.util.List;
import lotto.model.Guest;
import lotto.model.Product;
import lotto.model.Store;

public class LottoService {

  public List<Product> visit(Guest guest, Store store) {
    return guest.choiceProduct(store);
  }

}
