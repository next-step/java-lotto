package step3.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.InvalidSplitStringException;

class SplitterTest {

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4:4", "42,43,45:3", "1, 5, 7, 23:4"}, delimiter = ':')
  @DisplayName("정상 작동 테스트")
  void validExpressionSplitTest(String expression, int size) {
    Assertions.assertThat(Splitter.split(expression).size()).isEqualTo(size);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,a", "", " "})
  @DisplayName("수가 아닌 값이 들어왔을 때 익셉션 호출 테스트")
  void invalidExpressionSplitTest(String expression) {
    Assertions.assertThatThrownBy(() -> Splitter.split(expression)).isInstanceOf(InvalidSplitStringException.class);
  }
}