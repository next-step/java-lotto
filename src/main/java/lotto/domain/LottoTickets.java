package lotto.domain;

import lotto.domain.type.RewardPrice;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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

  public void updateMapValues(TreeMap<RewardPrice, Integer> map, WinningNumbers winningNumbers, LottoTickets lottoTickets) {
    for (LottoTicket lottoTicket : lottoTickets.tickets) {
      int matchNumberCount = winningNumbers.matchNumberCount(lottoTicket);
      RewardPrice key = RewardPrice.match(matchNumberCount);
      map.put(key, map.get(key) + 1);
    }
  }

  public List<LottoTicket> getTickets() {
    return Collections.unmodifiableList(tickets);
  }

  public double calculateProfitRate(int profitAmount) {
    return Math.floor((double) profitAmount / purchaseAmount.amount() * 100) / 100.0;
  }
}
