package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinStatisticsTest {
    List<LottoBalls> lotteries;
    LottoTickets lottoTickets;
    WinStatistics winStatistics;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<>();
        lotteries.add(LottoBalls.of(1, 2, 3, 7, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 10));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.from(lotteries);
    }

    @Test
    void 로또공들의_데이터가_주어질때_각_경우별로_1개씩_당첨되었을때_당첨_통계값이_일치해야한다() {
        winStatistics = WinStatistics.from(LottoBalls.of(1, 2, 3, 4, 5, 6), LottoBall.select(10), lottoTickets);
        assertThat(winStatistics.countByRank(Rank.FIFTH)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.FOURTH)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.THIRD)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.SECOND)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.FIRST)).isEqualTo(1);
    }

}
