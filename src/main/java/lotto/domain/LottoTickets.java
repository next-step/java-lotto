package lotto.domain;

import lotto.domain.type.RewardPrice;

import java.util.*;

public class LottoTickets {

  private final PurchaseAmount purchaseAmount;
  private final Set<LottoTicket> tickets;

  public LottoTickets(PurchaseAmount purchaseAmount, Set<LottoTicket> tickets) {
    this.purchaseAmount = purchaseAmount;
    this.tickets = tickets;
  }

  public static LottoTickets purchaseBy(int amount) {
    PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
    int ticketCount = purchaseAmount.ticketCount();
    
    Set<LottoTicket> lottoTickets = new HashSet<>();
    for (int i = 0; i < ticketCount; i++) {
      lottoTickets.add(LottoTicket.generate());
    }
    return new LottoTickets(purchaseAmount, lottoTickets);
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
