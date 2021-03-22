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
  @DisplayName("[Amount] 복권 수량 생성 테스트")
  void createAmountTest() {
    int quantity = amount.calculateAmount(14000);

    assertThat(quantity).isEqualTo(14);
  }

  @Test
  @DisplayName("[Amount] 입력 금액 검증 테스트")
  void validateTest() {
    assertThatThrownBy(() -> amount.validate(14500))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
