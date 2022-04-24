package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  void autoCreate() {
    assertThat(Lottos.autoCreate(10).size()).isEqualTo(10);
  }
}
