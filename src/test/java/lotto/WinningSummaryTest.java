package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.PRIZES;
import lotto.domain.WinningSummary;
import org.junit.jupiter.api.Test;

public class WinningSummaryTest {
  @Test
  void 당첨금_총합_계산() {
    WinningSummary summary = new WinningSummary();
    summary.add(PRIZES.FOURTH);
    summary.add(PRIZES.FIFTH);
    summary.add(PRIZES.FIFTH);

    long total = summary.calculateTotalWinning();

    assertThat(total).isEqualTo(50_000 + (5_000 * 2));
  }
}
