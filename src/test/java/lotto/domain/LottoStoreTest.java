package lotto.domain;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {

  @DisplayName("로또 구입")
  @Test
  void create() {
    assertThat(LottoStore.buyLottoCount("14000"))
        .isEqualTo(14);
  }

  @DisplayName("음수나 0이 입력되면 예외가 발생")
  @Test
  void validateInput() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoStore.buyLottoCount("0"));
  }

  @DisplayName("로또 금액 단위에 맞지 않는 금액 입력시 예외 발생")
  @Test
  void validateInputTwo() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoStore.buyLottoCount("3500"));
  }
}
