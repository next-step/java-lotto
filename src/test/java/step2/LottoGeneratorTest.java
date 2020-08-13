package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @Test
  void noneGenerateByMoney() {
    assertThatThrownBy(() -> LottoGenerator.generate(999).size())
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void generateByMoney() {
    assertThat(LottoGenerator.generate(1000).size()).isEqualTo(1);
  }

}
