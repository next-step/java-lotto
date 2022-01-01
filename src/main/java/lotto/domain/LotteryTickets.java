package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTickets {

  private static final int TICKET_MIN_COUNT = 0;
  private static final String WRONG_COUNT_EXCEPTION = "The ticket's count must be more than 0.";
  private static final String INDEX_OVER_EXCEPTION = "The ticket's count must be more than 0.";
  private final List<LotteryTicket> values;

  public LotteryTickets(int ticketCount) {
    validateAndThrow(ticketCount);
    this.values = Stream.generate(LotteryTicket::new)
        .limit(ticketCount)
        .collect(Collectors.toList());
  }

  public static LotteryTickets buy(Money money) {
    return new LotteryTickets(calculateCount(money));
  }

  private static int calculateCount(Money money) {
    return (int) (money.value() / LotteryTicket.PRICE);
  }

  public long cost() {
    return values.size() * LotteryTicket.PRICE;
  }

  public int size() {
    return values.size();
  }

  public List<LotteryTicket> lotteryTickets() {
    return values;
  }

  public LotteryTicket lotteryTicket(int index) {
    if (index >= values.size()) {
      throw new IllegalArgumentException(INDEX_OVER_EXCEPTION);
    }

    return values.get(index);
  }

  private void validateAndThrow(int ticketCount) {
    if (ticketCount < TICKET_MIN_COUNT) {
      throw new IllegalArgumentException(WRONG_COUNT_EXCEPTION);
    }
  }
}
