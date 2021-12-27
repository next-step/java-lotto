package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryStatisticTest {

  @Test
  @DisplayName("Test calculate statistic of tickets.")
  void testStatistic() {
    LotteryNumbers winning = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

    LotteryStatistic statistic = new LotteryStatistic();
    statistic.produceTickets(createTickets(), winning);

    double expected = (double) WinningLottery.FOURTH.getPrice() / (double) LotteryTicket.PRICE;
    assertEquals(expected, statistic.getProfit());
  }

  private LotteryTickets createTickets() {
    LotteryTickets tickets = new LotteryTickets(1);
    tickets.getLotteryTicket(0).fixManual(new LotteryNumbers(Arrays.asList(4, 5, 6, 7, 8, 9)));
    return tickets;
  }
}
