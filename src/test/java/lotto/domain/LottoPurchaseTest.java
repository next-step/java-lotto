package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {
  @Test
  @DisplayName("로또 구매 금액이 1000원(로또 최소 금액) 미만일 경우 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoPurchaseAmount() {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchase(999));
  }

  @Test
  @DisplayName("로또 구입 개수를 반환한다.")
  void calculateLottoCount() {
    LottoPurchase lottoPurchase = new LottoPurchase(14000);
    assertThat(lottoPurchase.calculateLottoCount()).isEqualTo(14);
  }

}
