package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또의 티켓들의 등수를 가져온다.")
    void getResult() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoTicket);

        lottoTickets.calculate(winnerNumber);
        LottoResult resultRanks = lottoTickets.getResult();

        assertSoftly(softly -> {
            assertThat(resultRanks.getRackCount(LottoRank.FIRST)).isEqualTo(1);
            assertThat(resultRanks.getRackCount(LottoRank.SECOND)).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("1000원으로 구입한 로또 1등 당첨의 수익률은 2000000.0 이다 ")
    void rate() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTicket(lottoTicket);

        lottoTickets.calculate(winnerNumber);

        assertThat(lottoTickets.getRate(1000)).isEqualTo(2000000.0);

    }
}
