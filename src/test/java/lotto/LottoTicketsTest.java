package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
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
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 6));
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 7));
        tickets.add(new LottoTicket(1, 2, 3, 4, 5, 8));
        tickets.add(new LottoTicket(9, 10, 11, 12, 13, 14));
        LottoTickets lottoTickets = new LottoTickets(tickets);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new LottoTicket(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(lottoTickets.calculateWinningResults(lottoWinningNumbers)).containsExactly(Winning.FIRST, Winning.SECOND, Winning.THIRD, Winning.NONE);
    }
}
