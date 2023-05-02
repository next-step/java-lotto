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

  public LottoResults calculateLotteryResults(WinningNumbers winningNumbers) {
    List<Prize> prizes = new ArrayList<>();
    for (LottoTicket ticket : tickets) {
      int matchCount = ticket.matchCount(winningNumbers);
      Prize prize = Prize.valueOfMatchCount(matchCount);
      prizes.add(prize);
    }

    return convertMapWithPrize(prizes);
  }

  private static LottoResults convertMapWithPrize(List<Prize> prizes) {
    Map<Prize, Long> results = prizes.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return new LottoResults(results);
  }

  public LottoResults calculateLotteryResults(WinningNumbers winningNumbers, int bonusNumber) {
    List<Prize> prizes = new ArrayList<>();
    for (LottoTicket ticket : tickets) {
      int matchCount = ticket.matchCount(winningNumbers);
      boolean matchBonusNumber = ticket.contains(bonusNumber);
      Prize prize = Prize.valueOfMatchCountAndBonusNumber(matchCount, matchBonusNumber);
      prizes.add(prize);
    }

    return convertMapWithPrize(prizes);
  }
}
