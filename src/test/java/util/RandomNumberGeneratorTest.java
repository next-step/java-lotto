package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

  @Test
  void generate() {
    final int minNumber = 1;
    final int maxNumber = 10;
    for (int i = 0 ; i < 100 ; i++) {
      int result = RandomNumberGenerator.generateRandomNumberInRange(minNumber, maxNumber);
      assertThat(result).isBetween(minNumber, maxNumber);
    }
  }
}
