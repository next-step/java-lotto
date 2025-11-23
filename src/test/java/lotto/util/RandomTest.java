package lotto.util;


import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.game.Random;
import org.junit.jupiter.api.Test;

class RandomTest {

  @Test
  void randomGenerateTest() {
    assertThat(Random.generate().size()).isEqualTo(6);
  }
}