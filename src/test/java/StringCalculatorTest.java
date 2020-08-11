import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void givenEmpty_whenAdd_thenReturnZero(String value) {
    assertThat(StringCalculator.add(value)).isZero();
  }
}
