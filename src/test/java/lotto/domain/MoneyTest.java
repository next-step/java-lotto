package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

  @DisplayName("음수 입력시 예외처리")
  @Test
  void negative_money_exception() {
    assertThatThrownBy(() -> new Money(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력한 돈이 0보다 작습니다.");
  }

  @DisplayName("로또는 천원 이상일때 구매가 가능하다.")
  @ParameterizedTest
  @ValueSource(ints = {100,200,300,800,900,999})
  void available_lotto(int moneyInt) {
    Money money = new Money(moneyInt);
    assertThat(money.availableBuyLotto()).isFalse();
  }

  @DisplayName("로또 구입 가능한 개수 구하기")
  @Test
  void count_buying_lotto() {
    Money money = new Money(10500);
    assertThat(money.calculateTryLottoCount(1000)).isEqualTo(10);
  }

  @DisplayName("수익률 구하기")
  @Test
  void calculate_ROI() {
    Money investMoney = new Money(10000);
    Money earningMoney = new Money(20000);
    assertThat(earningMoney.calculateRate(investMoney)).isEqualTo(2.00);
  }

  @Test
  void plus() {
    Money money1 = new Money(1000);
    Money money2 = new Money(2000);
    assertThat(money1.plus(money2)).isEqualTo(new Money(3000));
  }

  @Test
  void multiply() {
    Money money = new Money(5000);
    assertThat(money.multiply(4)).isEqualTo(new Money(20000));
  }

}