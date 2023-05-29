package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import lotto.exception.TicketPriceOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Ticket.LOTTO_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    @DisplayName("금액에 맞춰 티켓이 생성되는지")
    public void generateNumber() {
        LottoTickets lottoTickets = LottoGenerator.generateAutoTickets(15500 / LOTTO_PRICE);
        assertThat(lottoTickets.numberOfTickets()).isEqualTo(15);
    }

    @Test
    @DisplayName("자동 티켓 구매 테스트")
    public void buyAutoTicketsTest() throws TicketNumberOutOfBoundException {
        assertThatThrownBy(() -> LottoTickets.buyAutoTickets(-1000)).isInstanceOf(TicketNumberOutOfBoundException.class);
        assertThat(LottoTickets.buyAutoTickets(14).numberOfTickets()).isEqualTo(14);
    }

    @Test
    @DisplayName("수동 티켓 구매 테스트")
    public void buyManualTicketsTest() throws TicketNumberOutOfBoundException {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(Ticket.from(List.of(1, 2, 3, 4, 5, 6)));
        ticketList.add(Ticket.from(List.of(1, 12, 13, 14, 15, 16)));
        assertThat(LottoTickets.buyManualTickets(ticketList).numberOfTickets()).isEqualTo(2);
    }

    @Test
    @DisplayName("통합 티켓(자동 + 수동) 구매 테스트")
    public void buyTicketsTest() throws TicketNumberOutOfBoundException, TicketPriceOutOfBoundException {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(Ticket.from(List.of(1, 2, 3, 4, 5, 6)));
        ticketList.add(Ticket.from(List.of(1, 12, 13, 14, 15, 16)));
        assertThat(LottoTickets.buyTickets(3000, ticketList).numberOfTickets()).isEqualTo(3);
    }

    @Test
    @DisplayName("수익률 계산기능 테스트")
    public void rateOfReturn() throws TicketNumberOutOfBoundException {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(Ticket.from(List.of(8, 21, 23, 41, 42, 43)));
        tickets.add(Ticket.from(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(Ticket.from(List.of(7, 11, 16, 35, 36, 44)));
        tickets.add(Ticket.from(List.of(1, 8, 11, 31, 41, 42)));
        tickets.add(Ticket.from(List.of(13, 14, 16, 38, 42, 45)));
        tickets.add(Ticket.from(List.of(7, 11, 30, 40, 42, 43)));
        tickets.add(Ticket.from(List.of(2, 13, 22, 32, 38, 45)));
        tickets.add(Ticket.from(List.of(23, 25, 33, 36, 39, 41)));
        tickets.add(Ticket.from(List.of(1, 3, 5, 14, 22, 45)));
        tickets.add(Ticket.from(List.of(5, 9, 38, 41, 43, 44)));
        tickets.add(Ticket.from(List.of(2, 8, 9, 18, 19, 21)));
        tickets.add(Ticket.from(List.of(13, 14, 18, 21, 23, 35)));
        tickets.add(Ticket.from(List.of(17, 21, 29, 37, 42, 45)));
        tickets.add(Ticket.from(List.of(1, 2, 3, 4, 5, 11)));
        LottoTickets lottoTickets = LottoTickets.from(tickets);

        WinningNumber winningNumber = WinningNumber.of(Ticket.from(List.of(1, 2, 3, 4, 5, 6)), BonusBall.from("7"));

        assertThat(lottoTickets.returnRate(winningNumber)).isEqualTo(107.5);
    }
}
