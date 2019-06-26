package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NumberGeneratorTest {

  @Test
  void randomNumberGenerate() {
    List<Integer> numbers = new RandomNumberGenerator().generate(Lotto.COUNT_OF_NUMBERS);
    assertThat(numbers.size()).isEqualTo(Lotto.COUNT_OF_NUMBERS);
  }

  @Test
  void mockNumberGenerate() {
    List<Integer> numbers = new MockNumberGenerator().generate(Lotto.COUNT_OF_NUMBERS);
    assertThat(numbers).contains(1,2,3,4,5,6);
  }
}
