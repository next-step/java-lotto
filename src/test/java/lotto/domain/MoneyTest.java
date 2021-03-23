package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @DisplayName("음수 입력시 예외처리")
  @Test
  void negative_money_exception() {
    assertThatThrownBy( () -> new Money(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력한 돈이 음수입니다.");
  }



}