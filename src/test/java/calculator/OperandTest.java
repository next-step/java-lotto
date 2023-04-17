package calculator;

import calculator.domain.Operand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

  @ParameterizedTest(name = "0 또는 양수 피연산자 입력하는 경우 해당 숫자 반환 테스트")
  @CsvSource(value = {"1:1", "10:10", "100:100", "01:1"}, delimiter = ':')
  public void number_숫자(String input, int expected) {
    Operand operand = new Operand(input);

    assertThat(operand.number()).isEqualTo(expected);
  }

  @ParameterizedTest(name = "숫자 이외의 값 또는 음수를 전달하는 경우 IllegalArgumentException throw 테스트")
  @ValueSource(strings = {"-1", "a", "-10"})
  public void number_숫자_이외의_값(String input) {
    assertThatThrownBy(() -> {
      Operand operand = new Operand(input);
    })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수를 입력해주세요.");
  }
}
