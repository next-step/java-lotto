package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    List<LottoBalls> lotteries;
    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<>();
        lotteries.add(LottoBalls.of(1, 2, 3, 7, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 8, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 9));
        lotteries.add(LottoBalls.of(1, 2, 3, 4, 5, 6));
        lottoTickets = new LottoTickets(lotteries);
    }

    @Test
    void 로또공들의_데이터가_주어질때_각_경우별로_1개씩_당첨되었을때_당첨_통계값이_일치해야한다() {
        Map<Integer, Integer> winStatistics = lottoTickets.getLottoStatistics(LottoBalls.of(1, 2, 3, 4, 5, 6));
        assertThat(winStatistics.get(3)).isEqualTo(1);
        assertThat(winStatistics.get(4)).isEqualTo(1);
        assertThat(winStatistics.get(5)).isEqualTo(1);
        assertThat(winStatistics.get(6)).isEqualTo(1);
    }

    @Test
    void 당첨_통계값이_주어질_때_통계값_일치해야한다() {
        Map<Integer, Integer> winStatistics = new HashMap<Integer, Integer>() {{
            put(3, 1);
        }};
        assertThat(lottoTickets.getRateOfReturn(14, winStatistics)).isEqualTo(0.35f);
    }
}
