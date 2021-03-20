package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {
  @Test
  @DisplayName("null과 공백값일 경우 0으로 생성이 되는가")
  public void createZero() throws Exception {
    //given
    Operand operand1 = new Operand(null);
    Operand operand2 = new Operand("");
    //when
    int expectedOperandValue1 = operand1.getOperand();
    int expectedOperandValue2 = operand2.getOperand();

    //then
    assertAll(
        () -> assertEquals(expectedOperandValue1, 0),
        () -> assertEquals(expectedOperandValue2, 0)
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "11", "22"})
  public void createProperlyNumber(String userInput) throws Exception {
    //given
    Operand operand = new Operand(userInput);
    //when
    //then
    assertEquals(operand.getOperand(), Integer.parseInt(userInput));
  }

  @ParameterizedTest
  @ValueSource(strings = {"abcd", "bbb", "-1", "-100"})
  public void createThrowException(String userInput) throws Exception {
    //given
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> new Operand(userInput));
  }
}