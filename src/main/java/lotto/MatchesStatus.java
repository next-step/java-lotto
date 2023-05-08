package lotto;

import java.math.BigDecimal;
import java.util.Objects;

public class MatchesStatus {

  private Integer threeMatchesCount = 0;
  private Integer fourMatchesCount = 0;
  private Integer fiveMatchesCount = 0;
  private Integer sixMatchesCount = 0;
  private BigDecimal rate;

  public BigDecimal findRateOfReturn(Lottos lottos) {
    return this.rate = lottos.findRateOfReturn(sumSixAmount(sumFiveAmount(sumFourAmount(sumThreeAmount(new BigDecimal("0"))))));
  }

  private BigDecimal sumSixAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(sixMatchesCount * Matches.MATCH_SIX.getWinningAmount()));
  }

  private BigDecimal sumFiveAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(fiveMatchesCount * Matches.MATCH_FIVE.getWinningAmount()));
  }

  private BigDecimal sumFourAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(fourMatchesCount * Matches.MATCH_FOUR.getWinningAmount()));
  }

  private BigDecimal sumThreeAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(threeMatchesCount * Matches.MATCH_THREE.getWinningAmount()));
  }

  public void saveMatches(Integer matchesNumber) {
    try {
      Objects.requireNonNull(Matches.getMatches(matchesNumber)).addCount(this);
    } catch (NullPointerException ignored) {
    }
  }

  void addOneAtThreeMatches() {
    threeMatchesCount++;
  }

  void addOneAtFourMatches() {
    fourMatchesCount++;
  }

  void addOneAtFiveMatches() {
    fiveMatchesCount++;
  }

  void addOneAtSixMatches() {
    sixMatchesCount++;
  }

  public Integer getThreeMatches() {
    return threeMatchesCount;
  }

  public Integer getFourMatches() {
    return fourMatchesCount;
  }

  public Integer getFiveMatches() {
    return fiveMatchesCount;
  }

  public Integer getSixMatches() {
    return sixMatchesCount;
  }

  public BigDecimal getRate() {
    return rate;
  }

}
