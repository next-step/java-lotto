package lotto.domain;

public class LottoStore {

  private static final int LOTTO_PRICE = 1000;

  public static int buyLottoCount(final String input) {
    final int price = validateInput(input);
    if (price % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 입력해야 합니다.");
    }
    return price / LOTTO_PRICE;
  }

  private static int validateInput(final String input) {
    final int price = Integer.parseInt(input);
    if (price <= 0) {
      throw new IllegalArgumentException("음수 또는 0을 입력할 수 없습니다. : " + input);
    }
    return price;
  }

}
