package stringcalculator.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Operator;

public class OperatorFactoryTest {

  OperatorFactory operatorFactory = new OperatorFactory();

  @DisplayName("연산자가 아닌 문자는 Operator를 만들 수 없다.")
  @ParameterizedTest
  @ValueSource(strings = {"1", ".", "=", "?"})
  public void create_throwException_notOperator(String input) {

    assertThatThrownBy(() -> operatorFactory.create(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("연산자인 문자는 Operator를 만들 수 없다.")
  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "/", "*"})
  public void convertOperator_Operator(String input) {

    assertThat(operatorFactory.create(input)).isInstanceOf(Operator.class);
  }
}
