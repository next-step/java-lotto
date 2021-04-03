package step2.domain.number;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.InvalidCountNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, -2})
  @DisplayName("유효하지 않은 회수 입력 테스트")
  void invalidCountTest(int number) {
    assertThatThrownBy(() -> new Count(number))
      .isInstanceOf(InvalidCountNumberException.class).hasMessage("회수의 최소 숫자는 0입니다.");
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1})
  @DisplayName("유효 회수 입력 테스트")
  void validCountTest(int number) {
    assertThat(new Count(number).showCount()).isEqualTo(number);
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1,1", "1,2,3"})
  @DisplayName("더하고 새로운 회수 생성 테스트")
  void addCount(int source, int operand, int result) {
    Count sourceCnt = new Count(source);
    Count targetCnt = new Count(operand);
    Count resultCnt = new Count(result);
    assertThat(sourceCnt.addCount(targetCnt)).isEqualTo(resultCnt);
  }

}