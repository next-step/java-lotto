package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

  private static final int PRICE_PER_LOTTO = 1000;

  private final List<Lotto> lottoTickets;

  public LottoTickets(int numberLottos) {
    lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberLottos; i++) {
      lottoTickets.add(new Lotto());
    }
  }

  public LottoTickets(List<Lotto> manualLottos, int autoLottoCount) {
    lottoTickets = new ArrayList<>(manualLottos);
    for (int i = 0; i < autoLottoCount; i++) {
      lottoTickets.add(new Lotto());
    }
  }

  public static LottoTickets of(int price) {
    return new LottoTickets(price / PRICE_PER_LOTTO);
  }

  public static LottoTickets of(List<Lotto> manualLottos, int price) {
    return new LottoTickets(manualLottos, (price / PRICE_PER_LOTTO) - manualLottos.size());
  }

  public int size() {
    return lottoTickets.size();
  }

  public LottoStatistics createWinningStatistics(Lotto winningNumbers, int bonusBall) {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    for (PrizeRank rank : PrizeRank.values()) {
      statistics.put(rank, 0);
    }

    for (Lotto ticket : lottoTickets) {
      updateRankCount(winningNumbers, bonusBall, ticket, statistics);
    }
    return new LottoStatistics(statistics, lottoTickets.size(), PRICE_PER_LOTTO);
  }

  private void updateRankCount(Lotto winningNumbers, int bonusBall, Lotto ticket,
      Map<PrizeRank, Integer> statistics) {
    PrizeRank rank = PrizeRank.valueOf(ticket.countMatchingNumbers(winningNumbers), ticket.hasBonusBall(bonusBall));
    if (rank != null) {
      statistics.merge(rank, 1, Integer::sum);
    }
  }

  public List<String> getLottoNumbersAsStrings() {
    return lottoTickets.stream()
        .map(Lotto::getNumbersAsString)
        .collect(Collectors.toList());
  }
}
