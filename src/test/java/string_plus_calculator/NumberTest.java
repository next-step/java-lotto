package string_plus_calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

  @Test
  @DisplayName("음수로 Number 객체 생성 시, RuntimeException")
  void minus_number_fail() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> Number.from("-1"))
        .withMessage("minus number is invalid.");
  }

  @Test
  @DisplayName("숫자가 아닌 String 으로 Number 객체 생성 시, IllegalArgumentException")
  void not_number_fail() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Number.from("hello"));
  }
}
