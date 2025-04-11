package lotto.domain;

public class LottoPrice {

  public static final int PRICE_PER_LOTTO = 1000;
  private final int price;

  private LottoPrice(int price) {
    validatePrice(price);
    this.price = price;
  }

  public static LottoPrice from(int price) {
    return new LottoPrice(price);
  }

  private static void validatePrice(int price) {
    if (price < PRICE_PER_LOTTO) {
      throw new IllegalArgumentException(
          String.format("로또 구매 금액은 %d원 이상이어야 합니다.", PRICE_PER_LOTTO)
      );
    }
    if (price % PRICE_PER_LOTTO != 0) {
      throw new IllegalArgumentException(
          String.format("로또 구매 금액은 %d원 단위여야 합니다.", PRICE_PER_LOTTO)
      );
    }
  }

  public int getPrice() {
    return price;
  }

  public int calculateLottoCount() {
    return price / PRICE_PER_LOTTO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoPrice that = (LottoPrice) o;
    return price == that.price;
  }

  @Override
  public int hashCode() {
    return price;
  }
} 