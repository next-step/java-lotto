package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {


  @ParameterizedTest(name = "[{index}] {0} {1} {2} = {3}")
  @CsvSource(value = {"2,+,3,5", "2,-,3,-1", "2,*,3,6", "6,/,2,3",}, delimiter = ',')
  @DisplayName("연산자 별로 결과값을 확인한다")
  void operate(Integer left,String operator,  Integer right, Integer expected ){
    int result = Operator.get(operator).apply(left,right);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest(name = "[{index}] : {arguments}")
  @ValueSource(strings = {"+", "-", "*", "/"})
  @DisplayName("입력이 지원하는 연산자인지 확인")
  void contains(String element){

    assertThat(Operator.supportedOperator(element)).isTrue();
  }

  @ParameterizedTest(name = "[{index}] : {arguments}")
  @ValueSource(strings = {"//", "%"})
  @DisplayName("입력이 지원하지 않는 연산자인지 확인")
  void containsFalse(String element){

    assertThat(Operator.supportedOperator(element)).isFalse();
  }
}
