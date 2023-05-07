package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  void 투자금액은_천단위로_들어오지_않으면_예외_던지는_검증() {
    assertThatThrownBy(() -> new Money(999))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 구입 금액은 천원 단위로 입력해주세요.");
  }
}