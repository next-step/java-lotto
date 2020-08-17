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
  void cantBuyAutoLottos() {
    assertThatThrownBy(() -> LottosGenerator.autoLottos(999, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void autoLottosByPayment() {
    assertThat(LottosGenerator.autoLottos(1000, 0).count()).isEqualTo(1);
  }

  @Test
  void autoLottosByPayment14000() {
    assertThat(LottosGenerator.autoLottos(14000, 0).count()).isEqualTo(14);
  }

  @Test
  void autoLottosIsOne() {
    assertThat(LottosGenerator.manualLottos(1000, new String[] {"1,2,3,4,5,6"}))
        .isEqualTo(Lottos.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
  }

  @Test
  void manualLottosIsTwo() {
    assertThat(LottosGenerator.manualLottos(2000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isEqualTo(
            Lottos.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))));
  }

  @Test
  void cantBuyManualLottos() {
    assertThatThrownBy(
        () -> LottosGenerator.manualLottos(1000, new String[] {"1,2,3,4,5,6", "2,3,4,5,6,7"}))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void invalidRangeOfNumbersAtManualLottos() {
    assertThatThrownBy(
        () -> LottosGenerator.manualLottos(1000, new String[] {"1,2,3,4,5,46"}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
