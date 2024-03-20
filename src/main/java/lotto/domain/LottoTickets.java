package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

  private final PurchaseAmount purchaseAmount;
  private final List<LottoTicket> tickets;

  public LottoTickets(int amount) {
    this.purchaseAmount = new PurchaseAmount(amount);
    this.tickets = LottoTicket.generate(this.purchaseAmount.ticketCount());
  }

  public LottoTickets(PurchaseAmount purchaseAmount, List<LottoTicket> tickets) {
    this.purchaseAmount = purchaseAmount;
    this.tickets = tickets;
  }

  public int ticketCount() {
    return this.purchaseAmount.ticketCount();
  }

  public boolean isSamePurchaseAmount(int amount) {
    return this.purchaseAmount.isSame(amount);
  }

  public boolean haveAll6Numbers() {
    return this.tickets.stream().allMatch(ticket -> ticket.size() == 6);
  }

  public boolean haveCorrectNumbers() {
    return this.tickets.stream().allMatch(LottoTicket::haveCorrectNumbers);
  }

  public Map<Integer, Integer> matchNumberCountMap(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
    Map<Integer, Integer> matchNumberCountMap = new HashMap<>();

    for (LottoTicket lottoTicket : lottoTickets.tickets) {
      int key = winningNumbers.matchNumberCount(lottoTicket);
      updateMapValue(matchNumberCountMap, key);
      insertMapValue(matchNumberCountMap, key);
    }

    return matchNumberCountMap;
  }

  public double calculateProfitRate(int profitAmount) {
    return Math.floor((double) profitAmount / purchaseAmount.amount() * 100) / 100.0;
  }

  private static void updateMapValue(Map<Integer, Integer> matchNumberCountMap, int key) {
    if (matchNumberCountMap.containsKey(key)) {
      matchNumberCountMap.put(key, matchNumberCountMap.get(key) + 1);
    }
  }

  private static void insertMapValue(Map<Integer, Integer> matchNumberCountMap, int key) {
    matchNumberCountMap.put(key, 1);
  }
}
