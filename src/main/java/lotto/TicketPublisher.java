package lotto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.dto.TicketPublisherDTO;

public class TicketPublisher {

  Map<TicketPublishType, Integer> publishingHistory;

  public TicketPublisher() {
    this.publishingHistory = new HashMap<>();
    this.publishingHistory.put(TicketPublishType.MANUAL, 0);
    this.publishingHistory.put(TicketPublishType.AUTO, 0);
  }

  public LottoTicket publishAutoTicket() {
    return LottoTicket.of(NumberPool.generateNumberBundle());
  }

  public LottoTicket publishAutoTicket(PublishStrategy publishStrategy) {
    return LottoTicket.of(NumberPool.generateNumberBundle(publishStrategy));
  }

  public LottoTickets publishAutoTickets(Budget budget) {
    int numPossibleTicket = budget.getNumPossibleBuyingTicket();

    this.publishingHistory.put(TicketPublishType.AUTO,
        this.publishingHistory.get(TicketPublishType.AUTO) + numPossibleTicket);

    return IntStream
        .range(0, numPossibleTicket)
        .mapToObj(x -> publishAutoTicket())
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  public LottoTickets publishManualTickets(List<LottoNumberBundle> bundles, Budget budget) {
    budget.reduceRemain(bundles.size());

    this.publishingHistory.put(TicketPublishType.MANUAL,
        this.publishingHistory.get(TicketPublishType.MANUAL) + bundles.size());

    return bundles.stream()
        .map(LottoTicket::of)
        .collect(collectingAndThen(toList(), LottoTickets::of));
  }

  public TicketPublisherDTO exportData() {
    return new TicketPublisherDTO(new HashMap<>(this.publishingHistory));
  }
}
