package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinStatisticsTest {
    List<LottoTicket> lotteries;
    LottoTickets lottoTickets;
    WinStatistics winStatistics;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<>();
        lotteries.add(LottoTicket.of(1, 2, 3, 7, 8, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 8, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 9));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 10));
        lotteries.add(LottoTicket.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.from(lotteries);
    }

    @Test
    void 로또공들의_데이터가_주어질때_각_경우별로_1개씩_당첨되었을때_당첨_통계값이_일치해야한다() {
        WinnerNumbers winnerNumbers = WinnerNumbers.from(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoBall.select(10));
        winStatistics = WinStatistics.from(winnerNumbers, lottoTickets);
        assertThat(winStatistics.result().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winStatistics.result().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winStatistics.result().get(Rank.THIRD)).isEqualTo(1);
        assertThat(winStatistics.result().get(Rank.SECOND)).isEqualTo(1);
        assertThat(winStatistics.result().get(Rank.FIRST)).isEqualTo(1);
    }

}
