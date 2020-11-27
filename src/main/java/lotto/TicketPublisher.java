package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class TicketPublisher {

  public TicketPublisher() {
  }

  public LottoTicket publishAutoTicket() {
    return LottoTicket.of(NumberPool.generateNumberBundle());
  }

  public LottoTicket publishAutoTicket(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle(publishStrategy));
  }

  public LottoTickets publishTickets(List<LottoNumberBundle> bundles, Budget budget) {
    budget.buyManualTickets(bundles.size());

    List<LottoTicket> manualTickets = bundles.stream()
        .map(LottoTicket::of)
        .collect(toList());

    List<LottoTicket> autoTickets = IntStream.
        range(0, budget.getNumPossibleAutoTickets())
        .mapToObj(x -> publishAutoTicket())
        .collect(toList());

    manualTickets.addAll(autoTickets);

    return LottoTickets.of(manualTickets);
  }
}
