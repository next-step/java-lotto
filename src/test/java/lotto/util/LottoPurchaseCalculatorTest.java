package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPurchaseCalculatorTest {

  @DisplayName("로또 갯수 구하기")
  @Test
  void testGetLottoCount() {
    assertAll(
        () -> assertThat(LottoPurchaseCalculator.toLottoCount(13900)).isEqualTo(13),
        () -> assertThat(LottoPurchaseCalculator.toLottoCount(14000)).isEqualTo(14),
        () -> assertThat(LottoPurchaseCalculator.toLottoCount(14100)).isEqualTo(14)
    );
  }
}
