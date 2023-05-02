package lotto3.util;

import static lotto3.domain.LottoTicket.TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;

public class LottoFactory {

  public static LottoTickets createLottoTickets(int investMoney) {
    int numberOfTickets = investMoney / TICKET_PRICE;
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberOfTickets; i++) {
      List<Integer> randomNumbers = RandomNumberGenerator.generate();
      lottoTickets.add(new LottoTicket(randomNumbers));
    }
    return new LottoTickets(lottoTickets);
  }

}
