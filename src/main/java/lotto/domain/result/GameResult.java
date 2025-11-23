package lotto.domain.result;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;

public class GameResult {

  private final Map<Rank, Integer> details;
  private final float rate;

  public GameResult(Map<Rank, Integer> details, int winningPrize, int purchaseAmount){
    this(details, calculateProfitRate(winningPrize, purchaseAmount));
  }

  public GameResult(Map<Rank, Integer> details, float rate) {
    this.details = details;
    this.rate = rate;
  }

  private static float calculateProfitRate(int winningPrize, int purchasePrize) {
    if (purchasePrize <= 0) {
      throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다");
    }
    if (winningPrize < 0) {
      throw new IllegalArgumentException("당첨 금액은 0 이상이어야 합니다");
    }
    return (float) winningPrize / purchasePrize;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("당첨 통계\n");
    sb.append("---------\n");
    sb.append(Arrays.stream(Rank.values())
        .filter(x -> x != Rank.NONE)
        .map(
            e -> String.format("%s - %d개", e, details.getOrDefault(e, 0))
        ).collect(Collectors.joining("\n"))).append("\n");
    sb.append("총 수익률은 ").append(this.rate).append("입니다.(기준이 1이기 때문에 결과적으로 ")
        .append(Explanation.getMessage(this.rate)).append("라는 의미임)");
    return sb.toString();
  }

  enum Explanation {
    PROFIT("이익"), LOSS("손해");
    private String message;

    Explanation(String message) {
      this.message = message;
    }

    static String getMessage(float value) {
      if (value >= 1) {
        return PROFIT.message;
      }
      return LOSS.message;
    }
  }
}