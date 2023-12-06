package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.Rank;

public class LottoResult {

  private final Map<Rank, Lottos> result;

  private LottoResult(Map<Rank, Lottos> result) {
    this.result = result;
  }

  public static LottoResult defaultOf(Map<Rank, Lottos> result) {
    return new LottoResult(result);
  }

  public int findMatchResultCount(Rank resultType) {
    return result.get(resultType).size();
  }

  public double calculateProfitRate(int amount) {
    double total = 0;
    for (Rank rank : Rank.values()) {
      if (rank.equals(Rank.NO_MATCH)) {
        continue;
      }
      total += this.calculatePrice(rank);
    }
    return total / amount;
  }

  private double calculatePrice(Rank rank) {
    return result.get(rank)
        .calculatePrice(rank);
  }

  public List<String> resultStatus() {
    return Arrays.stream(Rank.values())
        .filter(each -> each != Rank.NO_MATCH)
        .map(each -> each.resultMessage(result.get(each).size()))
        .collect(Collectors.toList());
  }
}
