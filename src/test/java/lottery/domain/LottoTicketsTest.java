package lottery.domain;

import lottery.code.WinPrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @Test
    @DisplayName("당첨 통계 테스트")
    void winStatisticsTest() {
        final LottoTicket lottoTicketA = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});
        final LottoTicket lottoTicketB = new LottoTicket(new Integer[]{2, 3, 4, 5, 6, 8});
        final LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicketA, lottoTicketB));
        final WinningLotto winningLotto = new WinningLotto("2, 3, 4, 5, 6, 7", 8);

        Map<WinPrizeType, Long> actual = lottoTickets.winStatistics(winningLotto);

        assertThat(actual).hasSize(2);
        assertThat(actual).contains(entry(WinPrizeType.THIRD, 1L), entry(WinPrizeType.SECOND, 1L));
        assertThat(actual).doesNotContainEntry(WinPrizeType.FIFTH, 0L);
    }

    @Test
    @DisplayName("로또 개수 테스트")
    void lottoTicketCountTest(){
        final LottoTicket lottoTicketA = new LottoTicket();
        final LottoTicket lottoTicketB = new LottoTicket();
        final LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicketA, lottoTicketB));

        Long actual = lottoTickets.lottoTicketCount();

        assertThat(actual).isEqualTo(2L);
    }

    @Test
    @DisplayName("로또 여러개 생성 테스트")
    void lottoTicketsTest() {
        final LottoTicket lottoTicketA = new LottoTicket();
        final LottoTicket lottoTicketB = new LottoTicket();
        final LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicketA, lottoTicketB));

        List<LottoTicket> actual = lottoTickets.lottoTickets();

        assertThat(actual).hasSize(2);
        assertThat(actual).contains(lottoTicketA, lottoTicketB);
    }

    @Test
    @DisplayName("로또 여러개 총 금액 테스트")
    void lottoTicketsTotalPriceTest(){
        final LottoTicket lottoTicketA = new LottoTicket();
        final LottoTicket lottoTicketB = new LottoTicket();
        final LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicketA, lottoTicketB));

        int actual = lottoTickets.lottoTicketsTotalPrice();

        int expected = LottoTicket.PRICE * 2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 여러개 총 당첨 금액 테스트")
    void lottoTicketsTotalPrizeTest(){
        final LottoTicket lottoTicketA = new LottoTicket();
        final LottoTicket lottoTicketB = new LottoTicket();
        final LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicketA, lottoTicketB));
        final Map<WinPrizeType, Long> matchStatistics = Map.of(
                WinPrizeType.FOURTH, 1L,
                WinPrizeType.THIRD, 1L);

        int actual = lottoTickets.lottoTicketsTotalPrize(matchStatistics);

        int expected = WinPrizeType.FOURTH.prize() + WinPrizeType.THIRD.prize();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("구매 금액 null 예외 처리 테스트")
    void nullInputMoneyThrowExceptionTest(Integer inputMoney) {
        assertThatThrownBy(() -> {
            new LottoTickets(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 필수 입니다.");
    }

    @Test
    @DisplayName("구매 금액 부적합한 단위 예외 처리 테스트")
    void unfitUnitInputMoneyThrowExceptionTest() {
        final Integer inputMoney = 1500;

        assertThatThrownBy(() -> {
            new LottoTickets(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000 단위 입니다.");
    }
}
