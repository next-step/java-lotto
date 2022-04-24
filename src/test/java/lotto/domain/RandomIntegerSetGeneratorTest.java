package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomIntegerSetGeneratorTest {

  @Test
  void getRandomIntegers() {
    assertThat(RandomIntegerSetGenerator.getRandomIntegers()).hasSize(6);
  }
}
