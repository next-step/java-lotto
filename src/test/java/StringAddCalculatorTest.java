import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringaddcalculator.StringAddCalculator;

public class StringAddCalculatorTest {

  @DisplayName("빈 문자열 및 NULL 입력 시 0을 반환한다.")
  @NullAndEmptySource
  @ParameterizedTest
  void 빈_문자열_입력에_0이_반환된다(String emptyText) {
    String result = Optional.of(StringAddCalculator.splitAndSum(emptyText))
        .orElseThrow(RuntimeException::new);
    assertThat(result).isEqualTo("0");
  }

  @DisplayName("하나의 숫자가 입력되면 해당 입력된 숫자를 반환한다")
  @Test
  void 하나의_숫자에_입력한_결과가_반환된다() {
    String result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo("1");
  }
}
