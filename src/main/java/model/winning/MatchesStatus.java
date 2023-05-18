package model.winning;

import java.math.BigDecimal;
import model.lotto.Lottos;

public class MatchesStatus {

  private Integer threeMatchesCount = 0;
  private Integer fourMatchesCount = 0;
  private Integer fiveMatchesCount = 0;
  private Integer fiveAndBonusMatchesCount = 0;
  private Integer sixMatchesCount = 0;
  private BigDecimal rate;

  public BigDecimal findRateOfReturn(Lottos lottos) {
    return this.rate = lottos.findRateOfReturn(sumSixAmount(sumFiveAndBonusAmount(sumFiveAmount(sumFourAmount(sumThreeAmount(new BigDecimal("0")))))));
  }

  private BigDecimal sumSixAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(sixMatchesCount * Matches.MATCH_SIX.getWinningAmount()));
  }

  private BigDecimal sumFiveAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(fiveMatchesCount * Matches.MATCH_FIVE.getWinningAmount()));
  }

  private BigDecimal sumFiveAndBonusAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(fiveAndBonusMatchesCount * Matches.MATCH_FIVE_AND_BONUS.getWinningAmount()));
  }

  private BigDecimal sumFourAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(fourMatchesCount * Matches.MATCH_FOUR.getWinningAmount()));
  }

  private BigDecimal sumThreeAmount(BigDecimal totalReturnAmount) {
    return totalReturnAmount.add(BigDecimal.valueOf(threeMatchesCount * Matches.MATCH_THREE.getWinningAmount()));
  }

  public void addMatchesCount(Matches matches) {
    try{
      matches.addCount(this);
    } catch (NullPointerException ignored) { }
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

  void addOneAtFiveAndBonusMatches() {
    fiveAndBonusMatchesCount++;
  }

  void addOneAtSixMatches() {
    sixMatchesCount++;
  }

  Integer getThreeMatches() {
    return threeMatchesCount;
  }

  Integer getFourMatches() {
    return fourMatchesCount;
  }

  Integer getFiveMatches() {
    return fiveMatchesCount;
  }

  Integer getFiveAndBonusMatches() {
    return fiveAndBonusMatchesCount;
  }

  Integer getSixMatches() {
    return sixMatchesCount;
  }

  public BigDecimal getRate() {
    return rate;
  }

}
