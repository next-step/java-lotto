package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

  @DisplayName("로또번호가 잘 할당되는지 확인한다.")
  @Test
  void constructorTest() {
    Number number = new Number(1);
    assertThat(number.get()).isEqualTo(1);
  }

  @DisplayName("로또번호를 검증하고 예외를 확인한다.")
  @Test
  void constructorExceptionTest() {
    assertThatThrownBy(() -> {
      new Number(46);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
