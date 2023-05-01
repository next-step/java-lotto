package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

  @DisplayName("0미만의 Money는 만들 수 없다.")
  @Test
  public void money_throwsException_minusMoney() {
    assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Money에 Money를 더한다.")
  @Test
  public void addMoney() {
    assertThat(new Money(1).addMoney(new Money(1))).isEqualTo(new Money(2));
    assertThat(new Money(2).addMoney(new Money(2))).isEqualTo(new Money(4));
  }

  @DisplayName("Money를 Money로 나눈다.")
  @Test
  public void getMoneyRate() {
    assertThat(new Money(1).getMoneyRate(new Money(1))).isEqualTo(1d);
    assertThat(new Money(1).getMoneyRate(new Money(2))).isEqualTo(0.50d);
    assertThat(new Money(1).getMoneyRate(new Money(3))).isEqualTo(0.33d);
    assertThat(new Money(1).getMoneyRate(new Money(4))).isEqualTo(0.25d);
    assertThat(new Money(1).getMoneyRate(new Money(5))).isEqualTo(0.20d);
    assertThat(new Money(1).getMoneyRate(new Money(6))).isEqualTo(0.17d);
  }
}
