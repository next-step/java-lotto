package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

  @Test
  void getRandomIntegers() {
    assertThat(LottoNumberGenerator.getRandomIntegers()).hasSize(6);
  }
}
