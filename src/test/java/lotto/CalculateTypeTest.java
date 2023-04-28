package lotto;

import lotto.utility.CalculateType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTypeTest {
  @Test
  @DisplayName("enum 사칙 연산자로 원하는 메서드 가져오기")
  public void  valueOfOperatorTest() {
    CalculateType result = CalculateType.valueOfOperator("+");

    assertThat(result.name()).isEqualTo("PLUS");

  }

  @Test
  @DisplayName("enum compute로 계산하기")
  public void  computeTest() {
    NumberFormat numberFormat = NumberFormat.getInstance();
    Double doubleNumber1 = Double.parseDouble("4");
    Double doubleNumber2 = Double.parseDouble("5");
    numberFormat.setGroupingUsed(false);

    String result = numberFormat.format(CalculateType.valueOfOperator("+").compute(doubleNumber1,doubleNumber2));

    assertThat(result).isEqualTo("9");

  }
}
