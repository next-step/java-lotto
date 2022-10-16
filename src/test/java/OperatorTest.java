import static org.assertj.core.api.Assertions.*;

import domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

  @Test
  @DisplayName("더하기 테스트")
  void plusTest() {
    int result = Operator.PLUS.calculate(5,5);
    assertThat(result).isEqualTo(10);
  }

  @Test
  @DisplayName("빼기 테스트")
  void minusTest(){
    int result = Operator.MINUS.calculate(10,5);
    assertThat(result).isEqualTo(5);
  }

  @Test
  @DisplayName("곱하기 테스트")
  void multiplyTest(){
    int result = Operator.MULTIPLY.calculate(10,10);
    assertThat(result).isEqualTo(100);
  }

  @Test
  @DisplayName("나누기 테스트")
  void divideTest(){
    int result = Operator.DIVIDE.calculate(100,10);
    assertThat(result).isEqualTo(10);
  }
}
