package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @Test
  void calculateYieldMiss() {
    verify(10000, 0, 0, 0, 0, 0, 0);
  }

  @DisplayName("하나의 rank와 일치할 때, 수익율을 계산할 수 있다.")
  @Test
  void calculateYieldFirst() {
    verify(10000, 1, 0, 0, 0, 0, 200_000);
  }

  @DisplayName("여러 개의 rank와 일치할 때, 수익율을 계산할 수 있다.")
  @Test
  void calculateYieldFirstAndSecond() {
    verify(10000, 1, 1, 0, 0, 0, 203_000);
  }

  private void verify(
      int amount,
      int first,
      int second,
      int third,
      int fourth,
      int fifth,
      double yield
  ) {
    PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
    LottoResult lottoResult = new LottoResult(
        Map.of(
            Rank.FIRST, first,
            Rank.SECOND, second,
            Rank.THIRD, third,
            Rank.FOURTH, fourth,
            Rank.FIFTH, fifth
        )
    );
    assertThat(lottoResult.calculateYield(purchaseAmount)).isEqualTo(yield);
  }
}
