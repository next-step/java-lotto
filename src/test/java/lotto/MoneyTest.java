package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

  @DisplayName("Money 객체 동등성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {2_000_000_000, 50_000, 5_000, 0})
  void createMoney(int won) {
    Money money = Money.of(won);
    assertThat(money).isEqualTo(Money.of(won));
  }
}
