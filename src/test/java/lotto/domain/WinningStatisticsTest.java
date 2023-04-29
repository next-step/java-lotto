package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.view.InputView.PRICE_OF_LOTTO_TICKET;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨 통계 테스트")
class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
    }

    @Test
    @DisplayName("일치하는 등수의 티켓이 없는 경우, 수익률은 0을 반환한다.")
    void calculateEarningsRateWhenNoWinningTickets() {
        int numberOfTickets = 10;

        double earningsRate = winningStatistics.calculateEarningsRate(numberOfTickets);

        assertEquals(0, earningsRate);
    }

    @Test
    @DisplayName("일치하는 티켓이 있을 때, 수익률을 올바르게 계산한다.")
    void calculateEarningsRate() {
        winningStatistics.addMatchedTicket(WinningRank.FOURTH);

        int numberOfTickets = 10;
        double expectedEarningsRate = 5_000 / (double) (numberOfTickets * PRICE_OF_LOTTO_TICKET);
        double actualEarningsRate = winningStatistics.calculateEarningsRate(numberOfTickets);

        assertEquals(expectedEarningsRate, actualEarningsRate, 0.5);
    }

    @Test
    @DisplayName("각 등수별 당첨 티켓 개수를 반환한다.")
    void getCount() {
        winningStatistics.addMatchedTicket(WinningRank.FIRST);
        winningStatistics.addMatchedTicket(WinningRank.THIRD);
        winningStatistics.addMatchedTicket(WinningRank.THIRD);
        winningStatistics.addMatchedTicket(WinningRank.THIRD);
        winningStatistics.addMatchedTicket(WinningRank.FOURTH);
        winningStatistics.addMatchedTicket(WinningRank.FOURTH);

        assertEquals(1, winningStatistics.getCount(WinningRank.FIRST));
        assertEquals(0, winningStatistics.getCount(WinningRank.SECOND));
        assertEquals(3, winningStatistics.getCount(WinningRank.THIRD));
        assertEquals(2, winningStatistics.getCount(WinningRank.FOURTH));
    }
}