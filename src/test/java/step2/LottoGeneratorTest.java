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
  void generateByPayment() {
    assertThat(LottoGenerator.generate(1000).size()).isEqualTo(1);
  }

  @Test
  void generateByPayment14000() {
    assertThat(LottoGenerator.generate(14000).size()).isEqualTo(14);
  }

}
