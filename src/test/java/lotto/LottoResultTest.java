package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

  @DisplayName("당첨금 수익률을 계산한다")
  @Test
  void calculateProfitRate() {
    Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)),
        new Lotto(List.of(1, 2, 3, 10, 11, 12)), new Lotto(List.of(7, 8, 9, 10, 11, 12))));
    Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    PurchaseAmount amount = new PurchaseAmount(lottos.count() * 1000);
    LottoResult lottoResult = new LottoResult(lottos.calculateMatchCounts(winningNumbers), amount);
    double rounded = Math.round(lottoResult.profitRate() * 10) / 10.0;
    assertThat(rounded).isEqualTo(3.3);
  }
}
