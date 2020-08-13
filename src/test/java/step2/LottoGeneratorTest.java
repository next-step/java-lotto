package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

  @Test
  void generateLotto() {
    Lotto lotto = LottoGenerator.generate();

    assertThat(lotto).isNotNull();
  }
}
