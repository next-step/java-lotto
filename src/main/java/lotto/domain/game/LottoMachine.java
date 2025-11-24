package lotto.domain.game;

import lotto.domain.lotto.LottoTickets;
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
    return new Purchase(lottoTicketPrice, generateTickets(calculate(money)));
  }

  private int calculate(Money money) {
    return money.divideForCount(lottoTicketPrice);
  }

  LottoTickets generateTickets(int cnt) {
    return new LottoTickets(cnt);
  }

}