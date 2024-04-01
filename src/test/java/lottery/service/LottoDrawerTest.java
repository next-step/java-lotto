package lottery.service;

import lottery.code.WinPrizeType;
import lottery.domain.LottoTicket;
import lottery.domain.LottoTickets;
import lottery.domain.ManualTickets;
import lottery.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawerTest {

    @Test
    @DisplayName("로또 당첨 통계 테스트")
    void winStatisticsTest(){
        final ManualTickets manualTickets = new ManualTickets(List.of(
                new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new Integer[]{2, 3, 4, 5, 6, 8})));
        final LottoTickets lottoTickets = new LottoTickets(manualTickets);
        final WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7", 8);
        final LottoDrawer lottoDrawer = new LottoDrawer(lottoTickets, winningLotto);

        Map<WinPrizeType, Long> actual = lottoDrawer.winStatistics();

        assertThat(actual).hasSize(2);
        assertThat(actual).contains(entry(WinPrizeType.THIRD, 1L), entry(WinPrizeType.SECOND, 1L));
        assertThat(actual).doesNotContainEntry(WinPrizeType.FIFTH, 0L);
    }

    @Test
    @DisplayName("수익률 계산")
    void profitRateTest(){
        final ManualTickets manualTickets = new ManualTickets(List.of(
                new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new Integer[]{10, 11, 12, 13, 14, 15}),
                new LottoTicket(new Integer[]{10, 11, 12, 13, 14, 15})));
        final LottoTickets lottoTickets = new LottoTickets(manualTickets);
        final WinningLotto winningLotto = new WinningLotto("4, 5, 6, 7, 8, 9", 45);
        final LottoDrawer lottoDrawer = new LottoDrawer(lottoTickets, winningLotto);

        BigDecimal actual = lottoDrawer.profitRate();

        BigDecimal expected = BigDecimal.valueOf(1.66);
        assertThat(actual).isEqualTo(expected);
    }
}
