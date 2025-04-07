package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  void 가격으로_로또_티켓_생성() {
    assertThat(LottoTickets.of(5000).size()).isEqualTo(5);
  }

  @Test
  void 로또_티켓_개수로_생성() {
    assertThat(new LottoTickets(3).size()).isEqualTo(3);
  }

  @Test
  void 당첨_통계_생성() {
    LottoTickets tickets = new LottoTickets(5);
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    int bonusBall = 7;

    LottoStatistics statistics = tickets.createWinningStatistics(winningNumbers, bonusBall);

    Map<PrizeRank, Integer> result = statistics.getRankCounts();
    assertThat(result).isNotNull();
    assertThat(result.values().stream().mapToInt(Integer::intValue).sum())
        .isLessThanOrEqualTo(tickets.size());
  }
} 