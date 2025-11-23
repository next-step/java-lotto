package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.result.Purchase;

public class LottoMachine {

  private static final int DEFAULT_LOTTO_TICKET_PRICE = 1000;

  private final int LOTTO_TICKET_PRICE;

  public LottoMachine() {
    this(DEFAULT_LOTTO_TICKET_PRICE);
  }

  public LottoMachine(int lottoTicketPrice) {
    this.LOTTO_TICKET_PRICE = lottoTicketPrice;
  }

  public Purchase purchase(int money) {
    return new Purchase(this.LOTTO_TICKET_PRICE, generateTickets(calculate(money)));
  }

  int calculate(int pay) {
    return pay / LOTTO_TICKET_PRICE;
  }

  List<LottoTicket> generateTickets(int cnt) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      tickets.add(LottoTicket.of(Random.generate()));
    }
    return tickets;
  }

}