package lotto3.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  public LottoTickets(List<LottoTicket> tickets) {
    this.tickets = tickets;
  }

  public int size() {
    return tickets.size();
  }

  public List<LottoTicket> tickets() {
    return tickets;
  }


  public LottoResults calculateLotteryResults(WinningNumbers winningNumbers,
      BonusNumber bonusNumber) {
    EnumMap<Prize, Long> results = tickets.stream()
        .map(ticket -> ticket.getLottoPrize(winningNumbers, bonusNumber))
        .collect(Collectors.groupingBy(prize -> prize, () -> new EnumMap<>(Prize.class),
            Collectors.counting()));

    return new LottoResults(results);
  }
}
