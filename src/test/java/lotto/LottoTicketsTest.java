package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @Test
    @DisplayName("로또 티켓 개수 확인")
    void lottoTicketCount() {
        int price = 3000;
        LottoTickets lottoTickets = LottoTickets.createByPrice(price);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 티켓들 Winning 확인")
    void calculateWinningResults() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )));
        tickets.add(new LottoTicket(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)
        )));
        tickets.add(new LottoTicket(List.of(
            new LottoNumber(9), new LottoNumber(10), new LottoNumber(11),
            new LottoNumber(12), new LottoNumber(13), new LottoNumber(14)
        )));
        LottoTickets lottoTickets = new LottoTickets(tickets);

        LottoTicket winningNumbers = new LottoTicket(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));

        assertThat(lottoTickets.calculateWinningResults(winningNumbers)).containsExactly(Winning.SIX_MATCH, Winning.FOUR_MATCH, Winning.NONE);
    }
}
