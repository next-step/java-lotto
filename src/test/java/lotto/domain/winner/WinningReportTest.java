package lotto.domain.winner;

import static lotto.domain.winner.WinningCondition.MATCH_FIVE;
import static lotto.domain.winner.WinningCondition.MATCH_FOR;
import static lotto.domain.winner.WinningCondition.MATCH_SIX;
import static lotto.domain.winner.WinningCondition.MATCH_THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.TicketBox;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningReportTest {

    @Test
    @DisplayName("주어진 티켓들로 당첨결과 업데이트하여 수익률 구하기")
    void update_winning_report_by_ticket_box() {
        WinningReport winningReport = new WinningReport();
        TicketBox ticketBox = new TicketBox(
                List.of(
                        new Ticket(List.of(5, 8, 24, 40, 42, 44)),
                        new Ticket(List.of(1, 6, 9, 24, 33, 40)),
                        new Ticket(List.of(5, 6, 7, 17, 25, 43)),
                        new Ticket(List.of(2, 10, 13, 23, 36, 42)),
                        new Ticket(List.of(5, 13, 28, 29, 31, 39))
                )
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(5, 6, 24, 25, 42, 43));

        winningReport.updateReport(ticketBox, winningNumbers);

        assertAll(
                () -> assertThat(winningReport.getWinningCount(MATCH_THREE)).isEqualTo(1),
                () -> assertThat(winningReport.getWinningCount(MATCH_FOR)).isEqualTo(1),
                () -> assertThat(winningReport.getWinningCount(MATCH_FIVE)).isEqualTo(0),
                () -> assertThat(winningReport.getWinningCount(MATCH_SIX)).isEqualTo(0),
                () -> assertThat(winningReport.getRateOfReturn(5000)).isEqualTo(11.00)
        );
    }

}
