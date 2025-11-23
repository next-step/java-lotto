package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.result.Purchase;

public class LottoMachine {

  private static final int DEFAULT_LOTTO_TICKET_PRICE = 1000;

  private final int lottoTicketPrice;

  public LottoMachine() {
    this(DEFAULT_LOTTO_TICKET_PRICE);
  }

  public LottoMachine(int lottoTicketPrice) {
    this.lottoTicketPrice = lottoTicketPrice;
  }

  public Purchase purchase(int money) {
    return new Purchase(this.lottoTicketPrice, generateTickets(calculate(money)));
  }

  int calculate(int pay) {
    return pay / lottoTicketPrice;
  }

  List<LottoTicket> generateTickets(int cnt) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      tickets.add(LottoTicket.of(Random.generate()));
    }
    return tickets;
  }

}