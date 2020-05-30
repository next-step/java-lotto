package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoTicket;

public class PurchaseService {

  private static final double TICKET_PRICE = 1000;

  public LottoTickets purchase(final Money money) {
    final int NUMBER_OF_PURCHASED_LOTTO = (int) (money.getMoney() / TICKET_PRICE);

    List<LottoTicket> lottoTicketList = new ArrayList<>();

    for (int index = 0; index < NUMBER_OF_PURCHASED_LOTTO; index++) {
      lottoTicketList.add(new LottoTicket());
    }

    return new LottoTickets(lottoTicketList);
  }
}
