package lotto;

import lotto.policy.FixedLottoNumberGeneratePolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
  private LottoGame lottoGame;

  @BeforeEach
  void beforeEach() {
    lottoGame = new LottoGame(14000, new FixedLottoNumberGeneratePolicy());
  }

  @Test
  void 로또_1장의_가격은_1000원이다() {
    assertThat(lottoGame.getLottoTickets().getTickets()).hasSize(14);
  }

  @Test
  void 통계() {
    Map<Integer, Integer> expectedLottoStatistics = new HashMap<>();
    expectedLottoStatistics.put(3, 2);
    expectedLottoStatistics.put(4, 0);
    expectedLottoStatistics.put(5, 0);
    expectedLottoStatistics.put(6, 1);
    Set<Integer> winners = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    lottoGame.getLottoTickets().calculateLottoStatistics(winners);
    LottoStatistics lottoStatistics = lottoGame.getLottoTickets().getLottoStatistics();

    assertThat(lottoStatistics.getStatistics())
        .isEqualTo(expectedLottoStatistics);
  }
}
