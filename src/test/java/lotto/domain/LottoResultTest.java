package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @Test
  void calculateYield() {
    PurchaseAmount amount = new PurchaseAmount(4000);
    LottoResult lottoResult = new LottoResult(
        Map.of(
            Rank.FIRST, 1,
            Rank.SECOND, 1,
            Rank.THIRD, 1,
            Rank.FOURTH, 1
        )
    );
    assertThat(lottoResult.calculateYield(amount)).isEqualTo((double) 2_001_555_000 / 4000);
  }
}
