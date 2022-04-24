package lotto;

import java.util.List;
import java.util.Objects;

public final class Store {

  private static final Integer PRODUCT_PRICE = 1000;
  private final Integer productCount;

  public Store() {
    this(0);
  }

  public Store(int productCount) {
    this.productCount = productCount;
  }

  public Store getProductsCount(Integer money) {
    return new Store(money / PRODUCT_PRICE);
  }

  public List<Integer> deliverLotto() {
    LottoFactory factory = new LottoFactory();
    return factory.apply();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Store store = (Store) o;
    return productCount.equals(store.productCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCount);
  }

  @Override
  public String toString() {
    return productCount.toString();
  }
}
