package lotto.model;

import java.util.ArrayList;
import java.util.List;

public final class Store {

  private static final Integer PRODUCT_PRICE = 1000;
  private final Integer productCount;

  public Store() {
    this(0);
  }

  public Store(int productCount) {
    this.productCount = productCount;
  }


  public List<Product> delivery(int money) {
    int count = money / PRODUCT_PRICE;
    List<Product> products = new ArrayList<>();
    while (count-- != 0) {
      products.add(deliverLotto());
    }
    return products;
  }

  private Product deliverLotto() {
    LottoFactory factory = new LottoFactory();
    return factory.apply();
  }


  @Override
  public String toString() {
    return productCount.toString();
  }

}