package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningStatusTest {
    LottoGameService lottoGameService;
    WinningNumber winningNumber;
    LottoTickets lottoTickets;
    WinningStatus winningStatus;

    @BeforeEach
    void init() throws TicketNumberOutOfBoundException {
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
        winningNumber = WinningNumber.of(Ticket.from(List.of(1, 2, 3, 4, 5, 6)), BonusBall.from("7"));
        lottoTickets = LottoTickets.from(tickets);
        lottoGameService = LottoGameService.of(lottoTickets, winningNumber);
        winningStatus = lottoTickets.winningStatus(winningNumber);
    }

    @Test
    @DisplayName("1, 2, 3, 4, 5등 테스트")
    public void countOfMatchingNumber() {
        assertThat(winningStatus.countOfPrize(PrizeType.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(winningStatus.countOfPrize(PrizeType.FOURTH_PRIZE)).isEqualTo(0);
        assertThat(winningStatus.countOfPrize(PrizeType.THIRD_PRIZE)).isEqualTo(1);
        assertThat(winningStatus.countOfPrize(PrizeType.SECOND_PRIZE)).isEqualTo(0);
        assertThat(winningStatus.countOfPrize(PrizeType.FIRST_PRIZE)).isEqualTo(0);
    }

    @Test
    @DisplayName("3등 테스트")
    public void thirdPrizeTest() {
        List<Ticket> tickets = new ArrayList<>();
        lottoTickets = LottoTickets.from(tickets);
        tickets.add(Ticket.from(List.of(1, 2, 3, 4, 5, 11)));
        winningStatus = lottoTickets.winningStatus(winningNumber);
        assertThat(winningStatus.countOfPrize(PrizeType.THIRD_PRIZE)).isEqualTo(1);
    }
}
