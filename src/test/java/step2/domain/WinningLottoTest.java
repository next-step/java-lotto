package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

  @DisplayName("로또번호가 잘 할당되는지 확인한다.")
  @Test
  void constructorTest() {
    WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
    int i = 1;
    for(Number number : winningLotto.getNumbers()) {
      assertThat(number.get()).isEqualTo(i++);
    }
  }

  @DisplayName("로또번호를 검증하고 예외를 확인한다.")
  @Test
  void constructorExceptionTest() {
    assertThatThrownBy(() -> {
      new WinningLotto("1,2,3,4,5,6,7");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
