package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculator {

  @ParameterizedTest
  @ValueSource(strings = {"", "  ", })
  void 입력값이빈공백일경우IllegalArgumentException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Calculator().validInput(input);
    });
  }

  @Test
  void 입력값이null일경우IllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Calculator().validInput(null);
    });
  }

}
