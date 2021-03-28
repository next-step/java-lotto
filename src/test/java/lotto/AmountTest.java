package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Amount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {

  private Amount amount;

  @BeforeEach
  void setUp() {
    amount = new Amount();
  }

  @Test
  @DisplayName("[Amount] 복권 자동 수량 생성 테스트")
  void createAmountTest() {
    int quantity = amount.calculateAutoAmount(14000, 2);

    assertThat(quantity).isEqualTo(12);
  }

  @Test
  @DisplayName("[Amount] 입력 금액 검증 테스트")
  void validateTest() {
    assertThatThrownBy(() -> amount.validate(14500, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[Amount] 수동 구매 수량 입력 테스트")
  void manualAmountTest() {
    amount = new Amount(14000, 2);

    int quantity = amount.getManualAmount();

    assertThat(quantity).isEqualTo(2);
  }

  @Test
  @DisplayName("[Amount] 수동 구매 수량 검증 테스트")
  void validateManualTest() {
    assertThatThrownBy(() -> amount.validate(14000, 15))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
