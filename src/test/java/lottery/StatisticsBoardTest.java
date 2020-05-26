package lottery;

import lottery.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsBoardTest {

    private LotteryMachine lotteryMachine;
    private LotteryTicket lastWinnerTicket;
    private LotteryTicket thirdWinnerTicket;
    private LotteryTicketsGroup winnerTicketsGroup;

    @BeforeEach
    public void setupVariables() {
        lotteryMachine = new LotteryMachine(new PurchasePrice(1000));
        lastWinnerTicket = new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 1, 2"));
        thirdWinnerTicket = new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 9, 3"));
        winnerTicketsGroup = new LotteryTicketsGroup(
                Arrays.asList(lastWinnerTicket, thirdWinnerTicket));
    }

    @DisplayName("우승 티켓 목록을 받으면 각 등수별 당첨자 수를 저장한 Map을 반환함")
    @Test
    public void getStatisticsBoard() {
        StatisticsBoard statisticsBoard = new StatisticsBoard(
                lotteryMachine.findWinnerTicketsMap(winnerTicketsGroup, lastWinnerTicket));

        assertThat(statisticsBoard.findTicketCountsByLotteryRank(LotteryRanks.FIRST_PRIZE))
                .isEqualTo(1);
        assertThat(statisticsBoard.findTicketCountsByLotteryRank(LotteryRanks.THIRD_PRIZE))
                .isEqualTo(1);
    }

    @DisplayName("수익률 계산")
    @Test
    public void getRetrunOfRate() {
        PurchasePrice purchasePrice = new PurchasePrice(LotteryRanks.FIRST_PRIZE.getPrizeMoney());
        StatisticsBoard statisticsBoard = new StatisticsBoard(
                lotteryMachine.findWinnerTicketsMap(winnerTicketsGroup, lastWinnerTicket));

        double returnOfRate = statisticsBoard.calculateRateOfReturn(purchasePrice);
        double totalRevenue = LotteryRanks.FIRST_PRIZE.getPrizeMoney() + LotteryRanks.FOURTH_PRIZE.getPrizeMoney();
        assertThat(returnOfRate).isEqualTo(totalRevenue / purchasePrice.getPurchasePrice());
    }
}
