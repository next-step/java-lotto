package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    List<LottoBalls> lotteries;
    LottoTickets lottoTickets;
    WinStatistics winStatistics;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<>();
        lotteries.add(LottoBalls.of(1, 2, 3, 7, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 6));
        lottoTickets = LottoTickets.from(lotteries);
    }

    @Test
    void 로또공들의_데이터가_주어질때_각_경우별로_1개씩_당첨되었을때_당첨_통계값이_일치해야한다() {
        winStatistics = WinStatistics.from(LottoBalls.of(1, 2, 3, 4, 5, 6), lottoTickets);
        assertThat(winStatistics.countByRank(Rank.FOURTH_RANK)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.THIRD_RANK)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.SECOND_RANK)).isEqualTo(1);
        assertThat(winStatistics.countByRank(Rank.FIRST_RANK)).isEqualTo(1);
    }

    @Test
    void 당첨_통계값이_14중_4등_당첨된_결과가_주어질_때_수익률이_0_35로_일치해야한다() {
        winStatistics = WinStatistics.from(LottoBalls.of(7, 8, 9, 41, 42, 43), lottoTickets);
        assertThat(lottoTickets.getRateOfReturn(14, winStatistics)).isEqualTo(0.35f);
    }
}
