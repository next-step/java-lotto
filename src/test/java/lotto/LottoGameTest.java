package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

  @DisplayName("로또 구입")
  @Test
  void create() {
    int buyLottoCount = LottoStore.buyLottoCount("14000");
    assertThat(buyLottoCount).isEqualTo(14);
  }
}
