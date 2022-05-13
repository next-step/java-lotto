package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

  @DisplayName("Money 객체 동등성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {2_000_000_000, 50_000, 5_000, 0})
  void createMoney(int won) {
    Money money = Money.createWon(won);
    assertThat(money).isEqualTo(Money.createWon(won));
  }

  @DisplayName("lessThan 만족시 True, 아니면 False를 반환한다")
  @ParameterizedTest
  @CsvSource(value = {"999, 1000, true", "1000, 1000, false"})
  void lessThan(int moenyA, int moneyB, boolean expect) {
    assertThat(Money.createWon(moenyA).lessThan(Money.createWon(moneyB))).isEqualTo(expect);
  }

  @DisplayName("")
  @ParameterizedTest
  @CsvSource(value = {"1, 0.0, 0", "0, 1.0, 0", "1000, 0.25, 250", "1000, 0.1, 100",
      "1500, 0.24, 360", "1500, 1.1, 1650", "-1000, 1.0, -1000", "1000, -1.0, -1000"})
  void multiply(int amount, double rate, int result) {
    assertThat(Money.createWon(amount).multiply(rate)).isEqualTo(Money.createWon(result));
  }

  @DisplayName("원 단위 문자열을 반환한다")
  @Test
  void won() {
    assertThat(Money.createWon(1000).won()).isEqualTo("1000원");
  }
}
