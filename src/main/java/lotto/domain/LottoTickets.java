package lotto.domain;

import lotto.domain.strategy.ShuffleStrategy;
import lotto.domain.type.RewardPrice;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.CORRECT_LOTTO_TICKET_SIZE;

public class LottoTickets {

  private static final int INIT_REWARD_PRICE_VALUE = 0;
  private final PurchaseAmount purchaseAmount;
  private final Set<LottoTicket> tickets;

  public LottoTickets(PurchaseAmount purchaseAmount, Set<LottoTicket> tickets) {
    this.purchaseAmount = purchaseAmount;
    this.tickets = tickets;
  }

  public static LottoTickets purchaseBy(PurchaseAmount purchaseAmount, List<Set<Integer>> manualLottoNumbers) {
    Set<LottoTicket> lottoTickets = convertLottoTickets(purchaseAmount, manualLottoNumbers);
    return new LottoTickets(purchaseAmount, lottoTickets);
  }

  public int autoTicketCount() {
    return this.purchaseAmount.autoTicketCount();
  }

  public int allTicketCount() {
    return this.purchaseAmount.allTicketCount();
  }

  public boolean isSamePurchaseAmount(int amount) {
    return this.purchaseAmount.isSame(amount);
  }

  public boolean haveAll6Numbers() {
    return this.tickets.stream().allMatch(ticket -> ticket.size() == CORRECT_LOTTO_TICKET_SIZE);
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
      map.put(reward, INIT_REWARD_PRICE_VALUE);
    }
    return map;
  }

  private static Set<LottoTicket> convertLottoTickets(PurchaseAmount purchaseAmount, List<Set<Integer>> manualLottoNumbers) {
    Set<LottoTicket> lottoTickets = initLottoTickets(manualLottoNumbers);

    ShuffleStrategy shuffleStrategy = new ShuffleStrategy();
    for (int i = 0; i < purchaseAmount.autoTicketCount(); i++) {
      lottoTickets.add(LottoTicket.generate(shuffleStrategy));
    }

    return lottoTickets;
  }

  private static Set<LottoTicket> initLottoTickets(List<Set<Integer>> lottoNumbers) {
    if (lottoNumbers.isEmpty()) {
      return new HashSet<>();
    }

    return lottoNumbers.stream()
        .map(LottoTicket::generate)
        .collect(Collectors.toSet());
  }
}
