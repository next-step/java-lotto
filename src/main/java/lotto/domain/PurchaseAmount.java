package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PurchaseAmount {

  private static final int LOTTO_PRICE = 1000;
  private static final int YIELD_SCALE = 2;
  private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 1000원 단위로 입력해주세요.";

  private final int value;

  public PurchaseAmount(int value) {
    validate(value);
    this.value = value;
  }

  public int getLottoCount() {
    return value / LOTTO_PRICE;
  }

  public BigDecimal getYield(int other) {
    return BigDecimal.valueOf(other)
        .divide(BigDecimal.valueOf(value), YIELD_SCALE, RoundingMode.HALF_EVEN);
  }

  private void validate(int value) {
    if (value <= 0 || value % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
    }
  }
}
