package lotto.domain.result;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;
import lotto.domain.lotto.Money;

public class GameResult {

  private final Map<Rank, Integer> details;
  private final BigDecimal rate;

  public GameResult(Map<Rank, Integer> details, Money winningPrize, Money purchaseAmount){
    this(details, winningPrize.divideBy(purchaseAmount));
  }

  public GameResult(Map<Rank, Integer> details, BigDecimal rate) {
    this.details = details;
    this.rate = rate;
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
        .append(Explanation.getMessage(this.rate)).append("(이)라는 의미임)");
    return sb.toString();
  }

  enum Explanation {
    PROFIT("이익"), LOSS("손해");
    private String message;

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