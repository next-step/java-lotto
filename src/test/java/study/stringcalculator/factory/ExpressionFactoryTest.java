package study.stringcalculator.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.stringcalculator.domain.InputValue;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionFactoryTest {

  @DisplayName("연산자로 끝나는 연산식의 길이는 짝수이므로 길이가 짝수면 Exception을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 +", "2 - 2 +"})
  public void create_throwsException_lengthEven(String input) {
    assertThatThrownBy(() -> ExpressionFactory.create(new InputValue(input)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
