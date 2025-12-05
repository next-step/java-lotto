package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoCountTest {

  @DisplayName("수동 장수가 구입 가능한 수량을 초과히면 예외를 발생한다")
  @Test
  void createManualLottoCount() {
    assertThatIllegalArgumentException().isThrownBy(() -> new ManualLottoCount(10, 1000))
        .withMessageContaining("구입 가능한 수량을 초과");
  }

}