package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.domain.LottoTicket;

public class PurchaseService {

  public LottoTickets purchase(final Money money) {
    final int numberOfPurchasedLotto = money.getNumberOfPurchasedLotto();

    List<LottoTicket> lottoTicketList = new ArrayList<>();

    for (int index = 0; index < numberOfPurchasedLotto; index++) {
      lottoTicketList.add(new LottoTicket());
    }

    return new LottoTickets(lottoTicketList);
  }
}
