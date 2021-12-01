package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyNumbersTest {

  @Test
  public void test() {
    MyNumbers myNumbers = MyNumbers.from(new String[]{"1", "2", "3"});
    assertEquals(myNumbers.addAll(), 6);
  }
}
