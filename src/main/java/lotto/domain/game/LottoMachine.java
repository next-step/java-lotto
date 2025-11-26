package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoTicket;
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

  public Purchase createPurchase(Money budget, int manualCount) {
    return new Purchase(budget, lottoTicketPrice, manualCount);
  }

  public LottoTickets generateTickets(List<String> manualTickets, int autoCount) {
    List<LottoTicket> manual = convert(manualTickets);
    List<LottoTicket> auto = generate(autoCount);

    List<LottoTicket> allTickets = new ArrayList<>(manual);
    allTickets.addAll(auto);
    return new LottoTickets(allTickets);
  }

  private List<LottoTicket> convert(List<String> tickets) {
    return tickets.stream().map(LottoTicket::new).toList();
  }

  private List<LottoTicket> generate(int count) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      tickets.add(new LottoTicket(Random.generate()));
    }
    return tickets;
  }
}