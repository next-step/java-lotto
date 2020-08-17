package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottosGeneratorTest {

  @Test
  void generateLotto() {
    assertThat(LottosGenerator.generate()).isNotNull();
  }

  @Test
  void duplicateLotto() {
    assertThat(LottosGenerator.generate()).isNotEqualTo(LottosGenerator.generate());
  }

  @Test
  void cantByLotto() {
    assertThatThrownBy(() -> LottosGenerator.generate(999, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void generateByPayment() {
    assertThat(LottosGenerator.generate(1000, 0).count()).isEqualTo(1);
  }

  @Test
  void generateByPayment14000() {
    assertThat(LottosGenerator.generate(14000, 0).count()).isEqualTo(14);
  }

  @Test
  void asLottosIsOne() {
    assertThat(LottosGenerator.valueOf(1000, new String[] {"1,2,3,4,5,6"}))
        .isEqualTo(Lottos.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
  }

  @Test
  void asLottoIsTwo() {
    assertThat(LottosGenerator.valueOf(2000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isEqualTo(
            Lottos.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))));
  }

  @Test
  void cantBuyAsLottos() {
    assertThatThrownBy(
        () -> LottosGenerator.valueOf(1000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void invalidRangeOfNumbers() {
    assertThatThrownBy(
        () -> LottosGenerator.valueOf(1000, new String[] {"1,2,3,4,5,46"}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
