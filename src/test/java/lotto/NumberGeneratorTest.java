package lotto;

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
            .limit(6)
            .boxed()
            .collect(Collectors.toList());

    assertThat(numbers.size()).isEqualTo(6);
  }
}
