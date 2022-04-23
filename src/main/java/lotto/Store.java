package lotto;

import java.util.Objects;

public final class Store {

  private static final Integer PRODUCT_PRICE = 1000;
  private final int priceCount;

  public Store() {
    this(0);
  }

  public Store(int priceCount) {
    this.priceCount = priceCount;
  }

  public Store getProductsCount(Integer money) {
    return new Store(money / PRODUCT_PRICE);
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
    return priceCount == store.priceCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(priceCount);
  }
}
