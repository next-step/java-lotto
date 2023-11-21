package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TicketTest {

        @Test
        void 한_장의_로또_티켓_내_포함된_당첨_번호_갯수() {
                LottoNumbers numbers = new LottoNumbers(1, 2, 3, 7, 8, 9);
                WinningNumbers winningNumbers = new WinningNumbers(new LottoNumber(10), 1, 2, 3, 4, 5, 6);
                Ticket ticket = new Ticket(numbers);

                ticket.countWinningNumber(winningNumbers);

                assertThat(ticket.countWinningNumber(winningNumbers)).isEqualTo(3);
        }
}
