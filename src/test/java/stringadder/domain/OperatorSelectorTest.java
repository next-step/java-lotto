package stringadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringadder.domain.OperatorSelector.*;

class OperatorSelectorTest {

  @DisplayName("기본 구분자 형태의 문자열이 전달되면 DEFAULT_DELIMITER enum 반환")
  @ValueSource(strings = {"1,2,3", "4:5:6", "24,55:11"})
  @ParameterizedTest
  void defaultDelimiterTest(String given) {
    assertThat(selectOperator(given)).isEqualTo(DEFAULT_DELIMITER);
  }

  @DisplayName("커스텀 구분자 형태의 문자열이 전달되면 CUSTOM_DELIMITER enum 반환")
  @ValueSource(strings = {"//;\\n1;2;3", "//!\\n4!7!9", "//@\\n11@23@74"})
  @ParameterizedTest
  void customDelimiterTest(String given) {
    assertThat(selectOperator(given)).isEqualTo(CUSTOM_DELIMITER);
  }

  @DisplayName("기본 구분자 형태, 커스텀 구분자 형태 둘 다 아닌 문자열이 전달되면 IllegalArgumentException 던짐")
  @ValueSource(strings = {"1!2@3", "//;\\n1!2!3"})
  @ParameterizedTest
  void unexpectedFormInputTest(String given) {
    assertThatThrownBy(() -> selectOperator(given)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("기본 구분자 형태, 커스텀 구분자 형태에 따라 알맞은 합계를 계산하는지 테스트")
  @CsvSource(value = {"//;\\n1;2;3$6", "//!\\n4!7!9$20", "//@\\n11@23@74$108", "1,2,3$6", "4:5:6$15", "24,55:11$90"}, delimiter = '$')
  @ParameterizedTest
  void calculateTest(String given, String expectation) {
    assertThat(selectOperator(given).calculate(given)).isEqualTo(new Number(expectation));
  }

}
