package lotto2.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  void 중복이_없는_랜덤한_숫자를_반환하는지_검증() {
    List<Integer> randomNumbers = RandomNumberGenerator.generate();

    Set<Integer> setOfNumbers = randomNumbers.stream()
        .collect(Collectors.toSet());

    assertThat(setOfNumbers.size()).isEqualTo(6);
  }

  @Test
  void 숫자의_범위가_1부터_45까지인지_검증() {
    List<Integer> randomNumbers = RandomNumberGenerator.generate();

    for (int number : randomNumbers) {
      assertThat(number).isBetween(1, 45);
    }
  }
}