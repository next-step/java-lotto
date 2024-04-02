package lottery.domain;

import lottery.code.WinPrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("당첨 통계 테스트")
    void winStatisticsTest() {
        final LottoTicket manualTicketA = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});
        final LottoTicket manualTicketB = new LottoTicket(new Integer[]{2, 3, 4, 5, 6, 8});
        final ManualTickets manualTickets = new ManualTickets(List.of(manualTicketA, manualTicketB));
        final LottoTickets lottoTickets = new LottoTickets(manualTickets);
        final WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7", 8);

        Map<WinPrizeType, Long> actual = lottoTickets.winStatistics(winningLotto);

        assertThat(actual).hasSize(2);
        assertThat(actual).contains(entry(WinPrizeType.THIRD, 1L), entry(WinPrizeType.SECOND, 1L));
        assertThat(actual).doesNotContainEntry(WinPrizeType.FIFTH, 0L);
    }

    @Test
    @DisplayName("로또 여러개 생성 테스트")
    void lottoTicketsTest(){
        final LottoTicket manualTicket = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});
        final LottoTicket quickTicket = new LottoTicket();
        final ManualTickets manualTickets = new ManualTickets(List.of(manualTicket));
        final QuickTickets quickTickets = new QuickTickets(List.of(quickTicket));

        LottoTickets actual = new LottoTickets(manualTickets, quickTickets);

        assertThat(actual.lottoTickets()).hasSize(2);
        assertThat(actual.lottoTickets()).contains(manualTicket, quickTicket);
        assertThat(actual.quickTicketCount()).isEqualTo(1L);
        assertThat(actual.manualTicketCount()).isEqualTo(1L);
        assertThat(actual.lottoTicketsTotalPrice()).isEqualTo(LottoTicket.PRICE * 2);
    }

    @Test
    @DisplayName("로또 여러개 총 당첨 금액 테스트")
    void lottoTicketsTotalPrizeTest(){
        final QuickTickets quickTickets = new QuickTickets(List.of(new LottoTicket(), new LottoTicket()));
        final LottoTickets lottoTickets = new LottoTickets(quickTickets);
        final Map<WinPrizeType, Long> matchStatistics = Map.of(
                WinPrizeType.FOURTH, 1L,
                WinPrizeType.THIRD, 1L);

        int actual = lottoTickets.lottoTicketsTotalPrize(matchStatistics);

        int expected = WinPrizeType.FOURTH.prize() + WinPrizeType.THIRD.prize();
        assertThat(actual).isEqualTo(expected);
    }
}
