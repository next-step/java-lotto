package lotto.domain;

import lotto.domain.type.RewardPrice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoTickets {

  private final PurchaseAmount purchaseAmount;
  private final Set<LottoTicket> tickets;

  public LottoTickets(int amount) {
    this.purchaseAmount = new PurchaseAmount(amount);
    this.tickets = LottoTicket.generate(this.purchaseAmount.ticketCount());
  }

  public LottoTickets(PurchaseAmount purchaseAmount, Set<LottoTicket> tickets) {
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

  public Map<RewardPrice, Integer> matchedNumberCountBy(WinningNumbers winningNumbers) {
    Map<RewardPrice, Integer> map = initMatchedNumberCountMap();
    for (LottoTicket lottoTicket : tickets) {
      int matchNumberCount = winningNumbers.matchNumberCount(lottoTicket);
      boolean isMatchBonusBall = winningNumbers.isMatchBonusBall(lottoTicket);
      RewardPrice key = RewardPrice.match(matchNumberCount, isMatchBonusBall);
      map.put(key, map.get(key) + 1);
    }
    return map;
  }

  public Set<LottoTicket> getTickets() {
    return Collections.unmodifiableSet(tickets);
  }

  public double calculateProfitRate(int profitAmount) {
    return Math.floor((double) profitAmount / purchaseAmount.amount() * 100) / 100.0;
  }

  private Map<RewardPrice, Integer> initMatchedNumberCountMap() {
    Map<RewardPrice, Integer> map = new HashMap<>();
    for (RewardPrice reward : RewardPrice.values()) {
      map.put(reward, 0);
    }
    return map;
  }
}
