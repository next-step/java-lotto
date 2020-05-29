package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class PurchaseService {

  public Integer purchase(final Integer payable) {
    final int DIVIDE_THRESHOLD = 1000;
    final int NUMBER_OF_PURCHASED_LOTTO = (payable / DIVIDE_THRESHOLD);
    LottoTickets lottoTickets = new LottoTickets();

    for (int index = 0; index < NUMBER_OF_PURCHASED_LOTTO; index++) {
      lottoTickets.updateLottoTickets(new LottoTicket());
    }

    return lottoTickets.numberOfLottoTickets();
  }
}
