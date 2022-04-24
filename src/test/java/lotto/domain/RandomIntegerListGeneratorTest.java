package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomIntegerListGeneratorTest {

  @Test
  void getRandomIntegers() {
    assertThat(RandomIntegerListGenerator.getRandomIntegers()).hasSize(6);
  }
}
