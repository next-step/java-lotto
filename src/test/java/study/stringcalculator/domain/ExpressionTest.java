package study.stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

  @DisplayName("연산자로 끝나는 연산식의 길이는 짝수이므로 길이가 짝수면 Exception을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 +", "2 - 2 +"})
  public void expression_ThrowsException_lengthEven(String input) {
    String[] expession = new InputValue(input).split();

    assertThatThrownBy(() -> new Expression(expession))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("숫자가 와야할 순서에 숫자가 아닌 문자를 만나면 Exception을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + +", "+ 1 +", "+ + 1"})
  public void calculate_throwException_outOfOrderNumber(String input) {
    String[] expession = new InputValue(input).split();

    assertThatThrownBy(() -> new Expression(expession).calculate())
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산이 와야할 순서에 사칙연산이 아닌 문자를 만나면 Exception을 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"1 1 1", "1 ? 1", "1 ^ 1"})
  public void calculate_throwException_outOfOrderOperator(String input) {
    String[] expession = new InputValue(input).split();

    assertThatThrownBy(() -> new Expression(expession).calculate())
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산을 정상적으로 수행한다.")
  @ParameterizedTest
  @CsvSource({"1 + 1,2", "2 - 1,1", "2 * 2,4", "4 / 3,1", "3 / 5 + 100,100", "1 + 1 + 1,3"})
  public void calculate_Result(String input, int result) {
    String[] expession = new InputValue(input).split();

    assertThat(new Expression(expession).calculate()).isEqualTo(result);
  }
}
