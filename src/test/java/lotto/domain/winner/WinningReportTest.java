package lotto.domain.winner;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static lotto.domain.winner.WinningCondition.MATCH_BONUS;
import static lotto.domain.winner.WinningCondition.MATCH_FIVE;
import static lotto.domain.winner.WinningCondition.MATCH_FOR;
import static lotto.domain.winner.WinningCondition.MATCH_SIX;
import static lotto.domain.winner.WinningCondition.MATCH_THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.number.LottoBall;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningReportTest {

    @ParameterizedTest
    @MethodSource("updateWinningReportByTicketBox")
    @DisplayName("주어진 티켓들로 당첨결과 업데이트하여 당첨된 티켓 수 구하기")
    void update_winning_report_by_ticket_box(TicketBox ticketBox, WinningTicket winningTicket,
            WinningCondition winningCondition, int expected) {
        WinningReport winningReport = new WinningReport();
        winningReport.updateReport(ticketBox, winningTicket);

        assertThat(winningReport.getWinningCount(winningCondition)).isEqualTo(expected);
    }

    @Test
    @DisplayName("주어진 티켓들과 당첨결과로 수익률 구하기")
    void update_rate_of_return() {
        WinningReport winningReport = new WinningReport();
        winningReport.updateReport(getTicketBox(), getWinningTicket());

        assertThat(winningReport.getRateOfReturn(new PurchasePrice(8000))).isEqualTo(253944.37);
    }

    private static Stream<Arguments> updateWinningReportByTicketBox() {
        return Stream.of(
                Arguments.arguments(getTicketBox(), getWinningTicket(), MATCH_THREE, 1),
                Arguments.arguments(getTicketBox(), getWinningTicket(), MATCH_FOR, 1),
                Arguments.arguments(getTicketBox(), getWinningTicket(), MATCH_FIVE, 1),
                Arguments.arguments(getTicketBox(), getWinningTicket(), MATCH_BONUS, 1),
                Arguments.arguments(getTicketBox(), getWinningTicket(), MATCH_SIX, 1)
        );
    }

    private static WinningTicket getWinningTicket() {
        return new WinningTicket(
                numbersToBalls(List.of(5, 6, 24, 25, 42, 43)), new LottoBall(7));
    }

    private static TicketBox getTicketBox() {
        return new TicketBox(
                List.of(
                        new Ticket(numbersToBalls(List.of(5, 8, 24, 40, 42, 44))),
                        new Ticket(numbersToBalls(List.of(1, 6, 9, 24, 33, 40))),
                        new Ticket(numbersToBalls(List.of(5, 6, 7, 17, 25, 43))),
                        new Ticket(numbersToBalls(List.of(2, 10, 13, 23, 36, 42))),
                        new Ticket(numbersToBalls(List.of(5, 13, 28, 29, 31, 39))),
                        new Ticket(numbersToBalls(List.of(5, 7, 24, 25, 42, 43))),
                        new Ticket(numbersToBalls(List.of(1, 5, 24, 25, 42, 43))),
                        new Ticket(numbersToBalls(List.of(5, 6, 24, 25, 42, 43)))
                )
        );
    }

}
