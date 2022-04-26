package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

  @DisplayName("유효하지 않은 값으로 생성하려하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1, 999, 1500})
  void create_invalid_number(int input) {
    assertThatThrownBy(() -> new PurchaseAmount(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void getLottoCount() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
    assertThat(purchaseAmount.getLottoCount()).isEqualTo(14);
  }
}
