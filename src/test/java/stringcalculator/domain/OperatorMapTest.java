package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.operator.Operator;

public class OperatorMapTest {

  @DisplayName("연산자가 아닌 문자는 Operator로 convert할 수 없다.")
  @ParameterizedTest
  @ValueSource(strings = {"1", ".", "=", "?"})
  public void convertOperator_throwException_notOperator(String input) {
    OperatorMap operatorMap = new OperatorMap();

    assertThatThrownBy(() -> operatorMap.convertOperator(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("연산자인 문자는 Operator로 convert한다.")
  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "/", "*"})
  public void convertOperator_Operator(String input) {
    OperatorMap operatorMap = new OperatorMap();

    assertThat(operatorMap.convertOperator(input)).isInstanceOf(Operator.class);
  }
}
