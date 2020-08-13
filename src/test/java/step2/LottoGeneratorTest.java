package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

  @Test
  void generateLotto() {
    assertThat(LottoGenerator.generate()).isNotNull();
  }

  @Test
  void duplicateLotto() {
    assertThat(LottoGenerator.generate()).isNotEqualTo(LottoGenerator.generate());
  }

}
