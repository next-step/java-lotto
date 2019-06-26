package lotto.domain;

public class LottoStore {

  private static final int LOTTO_PRICE = 1000;

  public static int buyLottoCount(final int price) {
    validatePrice(price);
    return validateInput(price) / LOTTO_PRICE;
  }

  private static void validatePrice(int price) {
    if (price % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 입력해야 합니다.");
    }
  }

  private static int validateInput(final int price) {
    if (price <= 0) {
      throw new IllegalArgumentException("음수 또는 0을 입력할 수 없습니다. : " + price);
    }
    return price;
  }

}
