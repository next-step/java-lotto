package lotto.domain.result;


public class GameResult {

  private final Statistics statistics;
  private final ProfitRate rate;

  public GameResult(Statistics statistics, ProfitRate rate) {
    this.statistics = statistics;
    this.rate = rate;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("당첨 통계\n");
    sb.append("---------\n");
    sb.append(statistics);
    sb.append(rate);
    return sb.toString();
  }
}