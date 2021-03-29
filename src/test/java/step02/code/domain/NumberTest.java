package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
  
  @Test
  @DisplayName("숫자의 min, max 체크 / 0 ~ 45")
  public void checkMinMax() {
    assertThatThrownBy(() -> {
      new Number(0);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      new Number(46);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("보너스 생성시, string 값이 int 로 변형 불가인 경우, error")
  public void numberByString() {
    assertThatThrownBy(() -> {
      Number.numberByString("j");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("숫자가 일치하면 true")
  public void isMatch() {
    Number matched = new Number(1);
    Number noneMatched = new Number(2);
    int number = 1;

    assertThat(matched.isMatch(number)).isTrue();
    assertThat(noneMatched.isMatch(number)).isFalse();
  }
}
