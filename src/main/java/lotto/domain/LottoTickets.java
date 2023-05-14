package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = new ArrayList<>(tickets);
  }

  public static LottoTickets issue(int number, LottoNumbersSelector selector) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      tickets.add(LottoTicket.bySize(
          LottoNumbers.LOTTO_NUMBER_COUNT_OUTBOUND,
          selector));
    }

    return new LottoTickets(tickets);
  }

  public LottoTickets append(LottoTickets lottoTickets) {
    this.tickets.addAll(lottoTickets.tickets());
    return new LottoTickets(this.tickets());
  }

  public LottoTickets append(LottoTicket lottoTicket) {
    this.tickets.add(lottoTicket);
    return new LottoTickets(this.tickets());
  }

  public List<LottoTicket> tickets() {
    return this.tickets;
  }

  public Map<Winning, Integer> score(List<LottoNumber> lastWeekNumbers, LottoNumber bonusNumber) {
    return this.tickets.stream()
        .map(ticket -> ticket.score(lastWeekNumbers, bonusNumber))
        .collect(Collectors.toMap(
            win -> win,
            win -> 1,
            (oldValue, newValue) -> oldValue + 1
        ));
  }
}
