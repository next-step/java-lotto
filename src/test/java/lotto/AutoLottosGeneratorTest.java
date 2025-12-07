package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AutoLottosGeneratorTest {

  @Test
  void generateAutoLottos() {
    assertThat(new AutoLottosGenerator(5).generate().count()).isEqualTo(5);
  }

}