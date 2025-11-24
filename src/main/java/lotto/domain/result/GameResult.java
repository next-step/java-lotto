package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;
import lotto.domain.lotto.Money;

public class GameResult {

  private final Map<Rank, Integer> ranks;

  public GameResult(){
    this(new HashMap<>());
  }

  public GameResult(Map<Rank, Integer> ranks) {
    this.ranks = ranks;
  }

  public void updateRank(Rank rank){
      ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
  }

  public String getProfitMessage(Money purchaseAmount) {
    int totalPrize = ranks.entrySet().stream()
        .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
        .sum();
    BigDecimal profit = new Money(totalPrize).divideBy(purchaseAmount);
    String explanation = Explanation.getMessage(profit);
    return String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
        profit, explanation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Arrays.stream(Rank.values())
        .filter(x -> x != Rank.NONE)
        .map(
            e -> String.format("%s - %d개", e, ranks.getOrDefault(e, 0))
        ).collect(Collectors.joining("\n")));
    return sb.toString();
  }

  enum Explanation {
    PROFIT("이익"), LOSS("손해");
    private final String message;

    Explanation(String message) {
      this.message = message;
    }

    static String getMessage(BigDecimal value) {
      if (value.compareTo(BigDecimal.ONE) >= 0) {
        return PROFIT.message;
      }
      return LOSS.message;
    }
  }
}