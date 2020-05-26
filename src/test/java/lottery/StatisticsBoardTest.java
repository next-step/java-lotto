package lottery;

import lottery.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsBoardTest {

    @DisplayName("우승 티켓 목록을 받으면 각 등수별 당첨자 수를 저장한 Map을 반환함")
    @Test
    public void getStatisticsBoard() {
        LotteryMachine lotteryMachine = new LotteryMachine(new PurchasePrice(1000));
        LotteryTicket lastWinnerTicket = new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 1, 2"));
        LotteryTicket thirdWinnerTicket = new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 9, 3"));
        LotteryTicketsGroup winnerTicketsGroup = new LotteryTicketsGroup(
                Arrays.asList(lastWinnerTicket, thirdWinnerTicket));

        StatisticsBoard statisticsBoard = new StatisticsBoard(
                lotteryMachine.findWinnerTicketsMap(winnerTicketsGroup, lastWinnerTicket));

        assertThat(statisticsBoard.findTicketCountsByLotteryRank(LotteryRanks.FIRST_PRIZE))
                .isEqualTo(1);
        assertThat(statisticsBoard.findTicketCountsByLotteryRank(LotteryRanks.THIRD_PRIZE))
                .isEqualTo(1);
    }
}
