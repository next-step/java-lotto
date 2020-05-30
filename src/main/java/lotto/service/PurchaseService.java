package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.collections.LottoTickets;

public class PurchaseService {

  public LottoTickets purchase(final Integer payable) {
    final int DIVIDE_THRESHOLD = 1000;
    final int NUMBER_OF_PURCHASED_LOTTO = (payable / DIVIDE_THRESHOLD);

    List<LottoTicket> lottoTicketList = new ArrayList<>();

    for (int index = 0; index < NUMBER_OF_PURCHASED_LOTTO; index++) {
      lottoTicketList.add(new LottoTicket());
    }

    return new LottoTickets(lottoTicketList);
  }
}
