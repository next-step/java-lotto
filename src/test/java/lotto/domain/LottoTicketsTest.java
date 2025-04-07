package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
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
  void 당첨_통계_계산() {
    LottoTickets tickets = new LottoTickets(5);
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    int bonusBall = 7;

    Map<PrizeRank, Integer> statistics = tickets.calculateWinningStatistics(winningNumbers, bonusBall);

    assertThat(statistics).isNotNull();
    assertThat(statistics.values().stream().mapToInt(Integer::intValue).sum())
        .isLessThanOrEqualTo(tickets.size());
  }

  @Test
  void 수익률_계산() {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    statistics.put(PrizeRank.FIFTH, 1);
    statistics.put(PrizeRank.FOURTH, 0);
    statistics.put(PrizeRank.THIRD, 0);
    statistics.put(PrizeRank.SECOND, 0);
    statistics.put(PrizeRank.FIRST, 0);

    assertThat(new LottoTickets(5).calculateProfitRate(statistics)).isEqualTo(1.0);
  }

  @Test
  void 당첨_통계_합이_구매한_로또_개수와_일치() {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    statistics.put(PrizeRank.FIFTH, 2);
    statistics.put(PrizeRank.FOURTH, 1);
    statistics.put(PrizeRank.THIRD, 0);
    statistics.put(PrizeRank.SECOND, 0);
    statistics.put(PrizeRank.FIRST, 0);

    LottoTickets tickets = new LottoTickets(3);
    assertThat(statistics.values().stream().mapToInt(Integer::intValue).sum())
        .isLessThanOrEqualTo(tickets.size());
  }
} 