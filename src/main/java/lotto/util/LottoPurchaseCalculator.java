package lotto.util;

public class LottoPurchaseCalculator {

  public static final int LOTTO_PRICE = 1_000;

  public static int toLottoCount(int price) {
    return price / LOTTO_PRICE;
  }
}
