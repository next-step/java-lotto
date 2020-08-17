package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
  void cantByLotto() {
    assertThatThrownBy(() -> LottoGenerator.generate(999, 0).size())
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void generateByPayment() {
    assertThat(LottoGenerator.generate(1000, 0).size()).isEqualTo(1);
  }

  @Test
  void generateByPayment14000() {
    assertThat(LottoGenerator.generate(14000, 0).size()).isEqualTo(14);
  }

  @Test
  void asLottosIsOne() {
    assertThat(LottoGenerator.asLottos(1000, new String[] {"1,2,3,4,5,6"}))
        .isEqualTo(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
  }

  @Test
  void cantByAsLottos() {
    assertThatThrownBy(
            () -> LottoGenerator.asLottos(1000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void asLottoIsTwo() {
    assertThat(LottoGenerator.asLottos(2000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isEqualTo(
            Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))));
  }
}
