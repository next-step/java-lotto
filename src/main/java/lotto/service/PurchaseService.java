package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.collections.LottoTickets;

public class PurchaseService {

  private static final double TICKET_PRICE = 1000;

  public LottoTickets purchase(final Integer payable) {
    final int NUMBER_OF_PURCHASED_LOTTO = (int) (payable / TICKET_PRICE);

    List<LottoTicket> lottoTicketList = new ArrayList<>();

    for (int index = 0; index < NUMBER_OF_PURCHASED_LOTTO; index++) {
      lottoTicketList.add(new LottoTicket());
    }

    return new LottoTickets(lottoTicketList);
  }
}
