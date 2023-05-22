package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TicketTest {
    @Test
    @DisplayName("한 장당 일치하는 당첨번호 개수")
    public void numberOfMatchingNumber() throws TicketNumberOutOfBoundException {
        Ticket ticket = Ticket.from(List.of(1, 2, 3, 44, 35, 36));

        WinningNumber winningNumber = WinningNumber.of(Ticket.from(List.of(1, 2, 3, 4, 5, 6)), BonusBall.from("7"));
        assertThat(ticket.checkLotteryWinningStatus(winningNumber).numberOfMatching()).isEqualTo(3);

        winningNumber = WinningNumber.of(Ticket.from(List.of(1, 2, 3, 44, 35, 36)), BonusBall.from("7"));
        assertThat(ticket.checkLotteryWinningStatus(winningNumber).numberOfMatching()).isEqualTo(6);
    }

    @Test
    @DisplayName("2등 테스트")
    public void secondPrize() throws TicketNumberOutOfBoundException {
        Ticket ticket = Ticket.from(List.of(1, 2, 3, 4, 5, 7));

        WinningNumber winningNumber = WinningNumber.of(Ticket.from(List.of(1, 2, 3, 4, 5, 6)), BonusBall.from("7"));
        assertThat(ticket.countMatchingNumber(winningNumber)).isEqualTo(5);
        assertThat(ticket.isBonusBallMatched(winningNumber)).isTrue();
        assertThat(ticket.checkLotteryWinningStatus(winningNumber).numberOfMatching()).isEqualTo(5);

        assertThat(ticket.checkLotteryWinningStatus(winningNumber)).isEqualTo(PrizeType.SECOND_PRIZE);
    }

    @Test
    @DisplayName("티켓 범위 validation 테스트")
    public void ticketValidationTest()  {
        assertThatThrownBy(() -> Ticket.from(List.of(1, 2, 3, 4, 5, 46))).isInstanceOf(TicketNumberOutOfBoundException.class);
        assertThatThrownBy(() -> Ticket.from(List.of(-1, 2, 3, 4, 5, 6))).isInstanceOf(TicketNumberOutOfBoundException.class);
        assertThat(Ticket.from(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("티켓에 LottoNo contains 테스트")
    public void containsTest() throws TicketNumberOutOfBoundException {
        Ticket ticket = Ticket.from(List.of(1, 2, 3, 4, 5, 6));
        assertThat(ticket.contains(LottoNo.from(1))).isTrue();
        assertThat(ticket.contains(LottoNo.from(6))).isTrue();
        assertThat(ticket.contains(LottoNo.from(10))).isFalse();
    }
}

