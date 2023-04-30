package lotto;

import lotto.utility.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.NumberFormat;


import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
  @ParameterizedTest
  @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLY", "/, DIVIDE"})
  @DisplayName("enum 사칙 연산자로 원하는 메서드 가져오기")
  public void  valueOfOperatorTest(String operator,Operation.BasicOperation expect ) {
    Operation result = Operation.BasicOperation.valueOfOperator(operator);

    assertThat(result).isEqualTo(expect);

  }

  @Test
  @DisplayName("enum compute로 계산하기")
  public void  computeTest() {
    NumberFormat numberFormat = NumberFormat.getInstance();
    Double doubleNumber1 = Double.parseDouble("4");
    Double doubleNumber2 = Double.parseDouble("5");
    numberFormat.setGroupingUsed(false);

    Double result = Operation.BasicOperation.valueOfOperator("+").compute(doubleNumber1,doubleNumber2);

    assertThat(result).isEqualTo(9.0);

  }
}
