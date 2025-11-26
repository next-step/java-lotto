package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

  @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(ints = {0, 900, 1500})
  void invalidMoney(int money) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new PurchaseAmount(money))
        .withMessageContaining("1000원 단위");
  }
}
