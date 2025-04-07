package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @Test
    @DisplayName("당첨 티켓과 구매 티켓을 비교하여 맞춘 개수별 통계를 계산할 수 있다.")
    void shouldCalculateRankCounts() {
        // given
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6), 7);
        List<LottoTicket> purchaseTickets = List.of(
            new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
            new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), // 5개 일치 + 보너스 숫자
            new LottoTicket(List.of(1, 2, 3, 4, 5, 45)), // 5개 일치
            new LottoTicket(List.of(1, 2, 3, 4, 44, 45)), // 4개 일치
            new LottoTicket(List.of(1, 2, 3, 43, 44, 45)), // 3개 일치
            new LottoTicket(List.of(1, 2, 42, 43, 44, 45)) // 2개 일치
        );

        // when
        LottoStatistics statistics = new LottoStatistics(winningTicket, purchaseTickets);

        // then
        assertThat(statistics.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(statistics.getCountByRank(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("전체 상금을 올바르게 계산한다.")
    void shouldCalculateTotalWinningAmountCorrectly() {
        // given
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6), 7);
        List<LottoTicket> purchaseTickets = List.of(
            new LottoTicket(List.of(1, 2, 3, 4, 5, 6)) // 6개 일치
        );

        // when
        LottoStatistics statistics = new LottoStatistics(winningTicket, purchaseTickets);

        assertThat(statistics.calculateTotalWinningAmount())
            .isEqualTo(LottoRank.FIRST.getPrizeMoney(1));
    }
}
