package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

  private static final int LOTTO_TICKET_PRICE = 1000;

  public static List<LottoTicket> buy(final long amount) {
    long ticketCount = getTicketCount(amount);
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      lottoTickets.add(new LottoTicket(LottoFactory.create()));
    }
    return lottoTickets;
  }

  private static long getTicketCount(final long amount) {
    return amount / LOTTO_TICKET_PRICE;
  }
}
