package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTickets {

  private final List<LotteryTicket> lotteryTickets;

  public LotteryTickets(int ticketCount) {
    validate(ticketCount);
    this.lotteryTickets = Stream.generate(LotteryTicket::new)
        .limit(ticketCount)
        .collect(Collectors.toList());
  }

  public static List<LotteryTicket> buy(Money money) {
    return new LotteryTickets(calculateCount(money)).lotteryTickets;
  }

  private static int calculateCount(Money money) {
    return (int) (money.getValue() / (long) LotteryTicket.PRICE);
  }

  private void validate(int ticketCount) {
    if (ticketCount < 0) {
      throw new IllegalArgumentException("The ticket's count must be more than 0.");
    }
  }
}
