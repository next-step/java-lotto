package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @Test
    @DisplayName("당첨 티켓과 구매 티켓을 비교하여 맞춘 개수별 통계를 계산할 수 있다.")
    void shouldCalculateMatchCounts() {
        // given
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket[] purchaseTickets = new LottoTicket[]{
            new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
            new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), // 5개 일치
            new LottoTicket(List.of(1, 2, 3, 4, 8, 9)), // 4개 일치
            new LottoTicket(List.of(1, 2, 3, 7, 8, 9)), // 3개 일치
            new LottoTicket(List.of(1, 2, 7, 8, 9, 10)) // 2개 일치
        };

        // when
        LottoStatistics statistics = new LottoStatistics(winningTicket, purchaseTickets);

        // then
        assertThat(statistics.getCountByMatches(6)).isEqualTo(1);
        assertThat(statistics.getCountByMatches(5)).isEqualTo(1);
        assertThat(statistics.getCountByMatches(4)).isEqualTo(1);
        assertThat(statistics.getCountByMatches(3)).isEqualTo(1);
        assertThat(statistics.getCountByMatches(2)).isEqualTo(1);
    }

}
