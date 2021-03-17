package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  @DisplayName("입력 금액에 따라 구입한 로또 갯수 확인")
  public void calculateLottoCount() {
    Money money = new Money(14000);
    assertEquals(14, money.calculateLottoCount());
  }

  @Test
  @DisplayName("1000원이상 금액 확인")
  public void validatePurchasePrice() {

    assertThatIllegalArgumentException().isThrownBy(() -> {
      Money money = new Money(900);
    });
  }
}
