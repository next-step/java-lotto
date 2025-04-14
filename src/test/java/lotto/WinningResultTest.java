package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PRIZES;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

  @Test
  void 당첨_결과를_정확히_생성한다() {
    Lotto fifthLotto = new Lotto(() -> Arrays.asList(1, 2, 3, 10, 11, 12));
    Lotto missLotto = new Lotto(() -> Arrays.asList(10, 11, 12, 13, 14, 15));

    WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    List<Lotto> lottos = Arrays.asList(fifthLotto, missLotto);

    WinningResult result = WinningResult.of(lottos, winningLotto);

    assertThat(result.getWinningCount(PRIZES.FIFTH)).isEqualTo(1);
    assertThat(result.getProfitRate()).isEqualTo(5000.0 / (2 * 1000));
  }
}
