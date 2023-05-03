package lotto3.util;

import static lotto3.domain.LottoTicket.TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;
import lotto3.domain.Money;

public class LottoFactory {

  public static LottoTickets createLottoTickets(Money investMoney) {
    int numberOfTickets = investMoney.numberOfTickets();
    List<LottoTicket> lottoTickets = IntStream.range(0, numberOfTickets)
        .mapToObj(i -> new LottoTicket(RandomNumberGenerator.generate()))
        .collect(Collectors.toList());
    return new LottoTickets(lottoTickets);
  }

}
