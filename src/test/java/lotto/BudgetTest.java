package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 500, 999})
  @DisplayName("불가능 한 수의 생성 테스트")
  void testOf(int input) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> Budget.of(input)
    );
  }

  @Test
  @DisplayName("이율 테스트")
  void testRatio() {
    Budget budget = Budget.of(10000);
    assertThat(budget.calculateRatio(11000))
        .isCloseTo(1.1, Percentage.withPercentage(0.01));
  }
}
