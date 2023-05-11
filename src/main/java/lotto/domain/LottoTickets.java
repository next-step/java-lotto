package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = new ArrayList<>(tickets);
  }

  public static LottoTickets issue(int number) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      tickets.add(LottoTicket.bySize(
          LottoNumbers.LOTTO_NUMBER_COUNT_OUTBOUND,
          new LottoNumbersRandomSelector()));
    }

    return new LottoTickets(tickets);
  }

  public List<LottoTicket> tickets() {
    return this.tickets;
  }

  public List<Integer> sameCounts(List<LottoNumber> lastWeekNumbers) {
    return this.tickets.stream()
        .map(ticket -> ticket.sameCount(lastWeekNumbers))
        .collect(Collectors.toList());
  }
}
