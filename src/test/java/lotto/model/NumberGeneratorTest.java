package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NumberGeneratorTest {

  @Test
  void makeNumbers() {
    List<Integer> numbers = new Random().ints(1, 46)
            .distinct()
            .limit(Lotto.COUNT_OF_NUMBERS)
            .boxed()
            .collect(Collectors.toList());

    assertThat(numbers.size()).isEqualTo(Lotto.COUNT_OF_NUMBERS);
  }

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
