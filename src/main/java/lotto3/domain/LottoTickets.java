package lotto3.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  public LottoTickets(List<LottoTicket> tickets) {
    this.tickets = tickets;
  }

  public static LottoTickets merge(LottoTickets manualLottoTickets, LottoTickets autoTickets) {
    List<LottoTicket> combinedTickets = new ArrayList<>(manualLottoTickets.tickets());
    combinedTickets.addAll(autoTickets.tickets());
    return new LottoTickets(combinedTickets);
  }

  public int size() {
    return tickets.size();
  }

  public List<LottoTicket> tickets() {
    return tickets;
  }


  public LottoResults calculateLotteryResults(LottoNumbers winningNumbers,
      LottoNumber bonusNumber) {
    Map<Prize, Long> results = tickets.stream()
        .map(ticket -> ticket.getLottoPrize(winningNumbers, bonusNumber))
        .collect(Collectors.groupingBy(Function.identity(), () -> new EnumMap<>(Prize.class),
            Collectors.counting()));

    return new LottoResults(results);
  }

}
