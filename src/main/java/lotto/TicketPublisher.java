package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

public class TicketPublisher {

  private TicketPublisher() {
  }

  static public LottoTicket publishTicket() {
    return LottoTicket.of(NumberPool.generateNumberBundle());
  }

  static public LottoTicket publishTicket(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle(publishStrategy));
  }

  static public LottoTickets publishTickets(int numTicket) {
    return IntStream
        .range(0, numTicket)
        .mapToObj(x -> publishTicket())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }
}
