package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

  private static final int LOTTO_TICKET_PRICE = 1000;

  public static LottoTickets buy(final Money amount) {
    long ticketCount = getTicketCount(amount);
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      lottoTickets.add((LottoFactory.create()));
    }
    return new LottoTickets(lottoTickets);
  }

  private static long getTicketCount(final Money amount) {
    return amount.divide(LOTTO_TICKET_PRICE).longValue();
  }
}
