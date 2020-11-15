package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAddCalculatorTest {
  @ParameterizedTest
  @DisplayName("입력값 빈 문자열 또는 null인 경우 0을반환")
  @ValueSource(strings = {"", "null"})
  public void 입력값_빈문자열_null인_경우(String value) {
    assertEquals(StringAddCalculator.splitAndSum(value), 0);
  }

  @ParameterizedTest
  @DisplayName("입력값이 하나일때")
  @ValueSource(ints = {5})
  public void 입력받은_값이_하나일때(int value) {
    assertEquals(StringAddCalculator.splitAndSum("5"), value);
  }

  @ParameterizedTest
  @DisplayName("문자열 덧셈 계산")
  @ValueSource(strings = {"//;\\n1;2;3,|:6"})
  public void 문자열_덧셈(String value) {
    assertEquals(StringAddCalculator.splitAndSum(value), 12);
  }

  @Test
  @DisplayName("입력값이 음수일때 예외처리")
  public void 입력값_음수일때_예외처리() {
    assertThatThrownBy(() -> StringAddCalculator.isNegative("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
  }

}
