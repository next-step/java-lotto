package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  private final static String LOWER_THAN_LOTTO_PRICE = "500";
  @Test
  @DisplayName("로또 금액보다 작으면 예외를 발생시킨다")
  void throwIfLowerThanLottoPrice() {
    assertThatThrownBy(() -> Money.toLottoPurchasablePrice(Money.from(LOWER_THAN_LOTTO_PRICE)));
  }
}