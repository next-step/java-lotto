package stringadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static stringadder.domain.DefaultDelimiterOperator.makeDefaultDelimiterOperatorFromOperatorSelector;

class DefaultDelimiterOperatorTest {

  @DisplayName("정적 팩토리 메서드 사용으로 객체 생성 테스트")
  @ValueSource(strings = {"1,2,3", "4:5:6", "24,55:11"})
  @ParameterizedTest
  void makeDefaultDelimiterOperatorFromOperatorSelectorTest(String given) {
    assertThat(makeDefaultDelimiterOperatorFromOperatorSelector(given)).isEqualTo(makeDefaultDelimiterOperatorFromOperatorSelector(given));
  }

  @DisplayName("입력값의 합계를 구하는 테스트")
  @CsvSource(value = {"1,2,3@6", "4:5:6@15", "24,55:11@90"}, delimiter = '@')
  @ParameterizedTest
  void sumTest(String given, String expectation) {
    assertThat(makeDefaultDelimiterOperatorFromOperatorSelector(given).sum()).isEqualTo(new Number(expectation));
  }
}
