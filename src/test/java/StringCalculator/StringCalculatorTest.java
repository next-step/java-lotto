package StringCalculator;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  void split_테스트() {
    String input = "2 + 3 * 4 / 2";

    int result = StringCalculator.init(input)
        .run();
  }
}
