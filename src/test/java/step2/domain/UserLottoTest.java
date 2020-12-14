package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottoTest {

  @DisplayName("로또번호가 잘 할당되는지 확인한다.")
  @Test
  void constructorTest() {
    List<Number> input = Arrays.asList(
        new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
    UserLotto userLotto = new UserLotto(input);
    assertThat(userLotto.getNumbers()).isEqualTo(input);
  }

  @DisplayName("로또번호를 검증하고 예외를 확인한다.")
  @Test
  void constructorExceptionTest() {
    assertThatThrownBy(() -> {
      new UserLotto(Collections.emptyList());
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 맞춘 갯수를 확인한다.")
  @Test
  void getMatchCountTest() {
    List<Number> input = Arrays.asList(
        new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
    UserLotto lotto = new UserLotto(input, new WinningLotto("1,2,3,7,8,9"));
    assertThat(lotto.getMatchCount()).isEqualTo(3);
  }
}

