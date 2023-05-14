package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualPurchaseNumberTest {

  @ParameterizedTest
  @ValueSource(strings = {"-1", "일"})
  @DisplayName("입력된 수가 음이 아닌 정수가 아니면 예외를 발생시킨다")
  void integerValidationTest(String input) {
    int ticketNumber = 3;
    assertThatThrownBy(() -> new ManualPurchaseNumber(input, ticketNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("티켓 수보다 더 많은 수가 입력되면 예외가 발생한다")
  void ticketNumberValidationTest() {
    int ticketNumber = 3;
    assertThatThrownBy(() -> new ManualPurchaseNumber("4", ticketNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }
}