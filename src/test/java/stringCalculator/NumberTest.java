package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

  @Test
  @DisplayName("숫자가 입력되지 않으면 예외가 발생한다")
  void notNumberTest() {
    assertThatThrownBy(() -> new Number("일"));
  }
}
