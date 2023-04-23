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
  void 로또_티켓하나는_6개의_번호가_부여된다() {
    for (LottoTicket lottoTicket : lottoGame.getLottoTickets().getTickets()) {
      assertThat(lottoTicket.getNumbers()).hasSize(6);
    }
  }

  @Test
  void 로또_티켓에_겹치는_숫자가_있으면_안된다() {
    for (LottoTicket lottoTicket : lottoGame.getLottoTickets().getTickets()) {
      Set<Integer> set = new HashSet<>(lottoTicket.getNumbers());
      assertThat(set).hasSize(6);
    }
  }

  @Test
  void 로또_티켓의_숫자는_오름차순으로_정렬되어있다() {
    for (LottoTicket lottoTicket : lottoGame.getLottoTickets().getTickets()) {
      for (int i = 0; i < lottoTicket.getNumbers().size() - 1; i++) {
        assertThat(lottoTicket.getNumbers().get(i))
            .isLessThan(lottoTicket.getNumbers().get(i + 1));
      }
    }
  }

  @Test
  void 당첨여부_판단() {
    LottoTickets lottoTickets = new LottoTickets(
        Arrays.asList(
            new LottoTicket(Arrays.asList(8, 21, 23, 41, 42, 43)),
            new LottoTicket(Arrays.asList(3, 5, 11, 16, 32, 38)),
            new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoTicket(Arrays.asList(1, 4, 6, 14, 19, 40))
        )
    );
    Set<Integer> winNumbers = new HashSet<>();
    winNumbers.add(1);
    winNumbers.add(2);
    winNumbers.add(3);
    winNumbers.add(4);
    winNumbers.add(5);
    winNumbers.add(6);
    Map<Integer, Integer> expectedStatistics = new HashMap<>();
    expectedStatistics.put(3, 1);
    expectedStatistics.put(4, 0);
    expectedStatistics.put(5, 0);
    expectedStatistics.put(6, 1);

    assertThat(lottoTickets.calculateLottoStatistics(winNumbers))
        .isEqualTo(expectedStatistics);
  }
}
