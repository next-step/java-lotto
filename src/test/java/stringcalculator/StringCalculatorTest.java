package stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {


  @Test
  void 덧셈() {
    StringCalculator stringCalculator = new StringCalculator();
    assertEquals(3, stringCalculator.calculateString("1 + 2"));
  }
}