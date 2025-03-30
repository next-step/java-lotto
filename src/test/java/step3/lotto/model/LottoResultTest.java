package step3.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    @DisplayName("로또 결과 테스트")
    void givenLottoTickets_whenLottoResult_thenSuccess() {
        // given
        LottoTicketList lottoTickets = new LottoTicketList(List.of(new LottoTicket("2, 3, 4, 5, 6, 7"),  // 5등
            new LottoTicket("3, 4, 5, 6, 7, 8"),  // 4등
            new LottoTicket("3, 5, 6, 7, 8, 9"),  // 3등
            new LottoTicket("4, 5, 6, 7, 8, 9"),  // 2등
            new LottoTicket("5, 6, 7, 8, 9, 10")  // 1등
        ));
        LottoTicketWinner lastWeekWinningTicket = new LottoTicketWinner(
            new LottoTicket("5, 6, 7, 8, 9, 10"),
            new LottoNumber(4)
        );

        // when
        LottoResult lottoResult = lottoTickets.scratchAll(lastWeekWinningTicket);

        // then
        assertThat(lottoResult.ticketCountOf(LottoPrize.FIFTH)).isEqualTo(new Count(1));
        assertThat(lottoResult.ticketCountOf(LottoPrize.FOURTH)).isEqualTo(new Count(1));
        assertThat(lottoResult.ticketCountOf(LottoPrize.THIRD)).isEqualTo(new Count(1));
        assertThat(lottoResult.ticketCountOf(LottoPrize.SECOND)).isEqualTo(new Count(1));
        assertThat(lottoResult.ticketCountOf(LottoPrize.FIRST)).isEqualTo(new Count(1));
    }

}
