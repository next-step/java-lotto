package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = new ArrayList<>(tickets);
  }

  public static LottoTickets issue(int number) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      tickets.add(LottoTicket.bySize(LottoNumbers.LOTTO_NUMBER_COUNT_OUTBOUND));
    }

    return new LottoTickets(tickets);
  }
}
