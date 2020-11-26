package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.lottoexception.RemainBudgetException;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "1234:1", "23232:23"}, delimiter = ':')
  @DisplayName("Lotto 구입 가능 숫자 확인")
  void testPurchaseLotto(int input, int expected) {
    assertThat(Budget.of(input).getNumPossibleBuyingTicket()).isEqualTo(expected);
  }

  @Test
  @DisplayName("이율 테스트")
  void testRatio() {
    Budget budget = Budget.of(10000);
    assertThat(budget.calculateRatio(11000))
        .isCloseTo(1.1, Percentage.withPercentage(0.01));
  }

  @Test
  @DisplayName("잔액 테스트(일반 구입 초과구입 비교)")
  void testRemain() {
    Budget ok = Budget.of(10000);
    Budget invalid = Budget.of(10000);

    ok.reduceRemain(6);
    invalid.reduceRemain(6);

    ok.reduceRemain(4);
    assertThatExceptionOfType(RemainBudgetException.class)
        .isThrownBy(
            () -> invalid.reduceRemain(5)
        );
  }
}
