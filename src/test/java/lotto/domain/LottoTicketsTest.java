package lotto.domain;

import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {

    @DisplayName("당첨번호를 입력하면 당첨통계를 반환한다")
    @Test
    void resultTest() {
        LottoTickets lottoTickets = createLottoTickets();
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResult lottoResult = lottoTickets.getLottoResult(winningNumbers);

        assertAll(
                () -> assertThat(lottoResult.getLottoStatistics().get(6)).isEqualTo(1),
                () -> assertThat(lottoResult.getLottoStatistics().get(3)).isEqualTo(2)
        );
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(7, 8, 9, 4, 5, 6));
        LottoTicket lottoTicket3 = new LottoTicket(Arrays.asList(1, 21, 3, 43, 12, 6));

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }

}