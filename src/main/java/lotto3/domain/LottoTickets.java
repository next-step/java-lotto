package lotto3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

  public Map<Prize, Long> calculateLotteryResults(List<Integer> winningNumbers) {
    List<Prize> prizes = new ArrayList<>();
    for (LottoTicket ticket : tickets) {
      int matchCount = ticket.matchCount(winningNumbers);
      Prize prize = Prize.valueOfMatchCount(matchCount);
      prizes.add(prize);
    }

    return convertMapWithPrize(prizes);
  }

  private static Map<Prize, Long> convertMapWithPrize(List<Prize> prizes) {
    return prizes.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
