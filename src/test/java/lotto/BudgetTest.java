package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BudgetTest {

  @Test
  @DisplayName("음수에 대한 예외 처리")
  void testOf() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> Budget.of(-1)
    );
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "0:0", "1234:1", "23232:23"}, delimiter = ':')
  @DisplayName("Lotto 구입 가능 숫자 확인")
  void testPurchaseLotto(int input, int expected) {
    assertThat(Budget.of(input).getNumPossibleLotto()).isEqualTo(expected);
  }
}