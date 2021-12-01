package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyNumberTest {

  @Test
  @DisplayName("Test MyNumber create.")
  public void testCreate() {
    MyNumber number = new MyNumber(1);
    assertEquals(number.getValue(), 1);
  }

  @Test
  @DisplayName("Test MyNumber parse.")
  public void testParse() {
    MyNumber number = new MyNumber(1);
    MyNumber parsedNumber = MyNumber.parse("1");
    assertEquals(number.getValue(), parsedNumber.getValue());
  }

  @Test
  @DisplayName("Test throw exception when number is negative or non-numeric.")
  public void testThrowException() {
    assertThrows(RuntimeException.class, () -> MyNumber.parse("-1"));
    assertThrows(RuntimeException.class, () -> MyNumber.parse("q"));
  }
}
