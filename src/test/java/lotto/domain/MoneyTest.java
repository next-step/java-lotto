package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

  @ParameterizedTest
  @ValueSource(ints = -1)
  @DisplayName("0보다 작으면 IllegalArgumentException.")
  void createPay_fail(int input) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Money(input));
  }

  @Test
  @DisplayName("로또를 구매할 수 없으면(1000원단위가 아니면) IllegalArgumentException.")
  void buyLotto_fail() {
    Money money = new Money(999);
    assertThatIllegalArgumentException()
        .isThrownBy(() -> money.getBuyableCount());
  }

  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "3000,3"})
  @DisplayName("로또를 몇개 살 수 있는지 확인한다.")
  void buyLotto(int input, int expected) {
    Money money = new Money(input);
    int buyLottoCount = money.getBuyableCount();
    assertEquals(buyLottoCount, expected);
  }
}