package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.InvalidNumberStrException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

  @Test
  @DisplayName("숫자 제대로 생성되는 지 확인")
  void number() {
    Number number = new Number("100");

    assertThat(number).usingRecursiveComparison().isEqualTo(new Number("100"));
  }

  @Test
  @DisplayName("잘못된 숫자 문자열 일 경우 에러")
  void wrongStr() {
    assertThatThrownBy(() -> {
      Number number = new Number("100123k");
    }).isInstanceOf(InvalidNumberStrException.class);
  }
}