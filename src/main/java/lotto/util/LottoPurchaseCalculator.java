package lotto.util;

import lotto.property.LottoProperty;

public class LottoPurchaseCalculator {

  public static int toLottoCount(int price) {
    return price / LottoProperty.LOTTO_PRICE;
  }
}
