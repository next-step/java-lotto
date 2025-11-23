package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;

public class LottoMachine {

  private static final Money DEFAULT_LOTTO_TICKET_PRICE = new Money(1_000);

  private final Money lottoTicketPrice;

  public LottoMachine() {
    this(DEFAULT_LOTTO_TICKET_PRICE);
  }

  public LottoMachine(Money lottoTicketPrice) {
    this.lottoTicketPrice = lottoTicketPrice;
  }

  public Purchase purchase(Money money) {
    return new Purchase(money, generateTickets(calculate(money)));
  }

  private int calculate(Money money) {
    return money.divideForCount(lottoTicketPrice);
  }

  List<LottoTicket> generateTickets(int cnt) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      tickets.add(LottoTicket.of(Random.generate()));
    }
    return List.copyOf(tickets);
  }

}