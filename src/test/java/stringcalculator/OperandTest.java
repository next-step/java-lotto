package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperandTest {

  @Test
  @DisplayName("입력된 피연산자 생성 확인")
  void checkInputOperandCreation () {
    // given
    String operand = "1";
    
    // when
    Operand operandCreation = new Operand(operand);
    
    // then
    assertThat(operandCreation.getValue()).isEqualTo(1);
  }
}