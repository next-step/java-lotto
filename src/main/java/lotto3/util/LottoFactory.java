package lotto3.util;

import static lotto2.domain.LottoTicket.TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto3.domain.LottoTicket;

public class LottoFactory {

  public static List<LottoTicket> createLottoTickets(int investMoney) {
    int numberOfTickets = investMoney / TICKET_PRICE;
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberOfTickets; i++) {
      List<Integer> randomNumbers = RandomNumberGenerator.generate();
      lottoTickets.add(new LottoTicket(randomNumbers));
    }
    return lottoTickets;
  }

}
