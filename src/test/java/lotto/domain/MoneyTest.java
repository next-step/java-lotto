package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

  @DisplayName("Money 객체 동등성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {2_000_000_000, 50_000, 5_000, 0})
  void createMoney(int won) {
    Money money = Money.of(won);
    assertThat(money).isEqualTo(Money.of(won));
  }

  @DisplayName("lessThan 만족시 True, 아니면 False를 반환한다")
  @ParameterizedTest
  @CsvSource(value = {"999, 1000, true", "1000, 1000, false"})
  void lessThan(int moenyA, int moneyB, boolean expect) {
    assertThat(Money.of(moenyA).lessThan(moneyB)).isEqualTo(expect);
  }
}
