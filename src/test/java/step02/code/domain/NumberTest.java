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
}
