package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoFactoryTest {

  @ParameterizedTest
  @CsvSource({
      "1000, 1",
      "800, 0",
      "0, 0",
      "1100, 1",
      "2000, 2",
      "2123, 2"
  })
  void createLottoByQuickPick(int money, int expected) {
    Lotto lotto = LottoFactory.createLottoByQuickPick(new Money(money));

    assertThat(lotto.getLottoList().size()).isEqualTo(expected);
  }

  @Test
  void createLottoByQuickPick_0원이하입력() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      LottoFactory.createLottoByQuickPick(new Money(-1000));
    });
  }
}