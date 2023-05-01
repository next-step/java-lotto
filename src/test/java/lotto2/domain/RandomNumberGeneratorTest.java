package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  @Test
  public void 랜덤넘버_6개를_만드는지_확인() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    List<Integer> generatedNumbers = rng.generate();

    assertThat(generatedNumbers.size()).isEqualTo(6);
  }

  @Test
  public void 랜덤숫자가_모두_1부터_45까지인지_검증() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    List<Integer> generatedNumbers = rng.generate();

    for (int number : generatedNumbers) {
      assertThat(number).isBetween(1, 45);
    }
  }

  @Test
  public void 중복된_랜덤_넘버_없는지_검증() {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    List<Integer> generatedNumbers = rng.generate();
    Set<Integer> uniqueNumbers = new HashSet<>(generatedNumbers);

    assertThat(generatedNumbers.size()).isEqualTo(uniqueNumbers.size());

  }

}