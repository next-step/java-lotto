package lotto;

import java.math.BigDecimal;

public class MatchesStatus {

  private Integer three = 0;
  private Integer four = 0;
  private Integer five = 0;
  private Integer six = 0;
  private BigDecimal rate;

  public BigDecimal findRateOfReturn(Lottos lottos) {
    BigDecimal totalReturnAmount = new BigDecimal("0");
    totalReturnAmount = totalReturnAmount.add(BigDecimal.valueOf(three * 5000L));
    totalReturnAmount = totalReturnAmount.add(BigDecimal.valueOf(four * 50000L));
    totalReturnAmount = totalReturnAmount.add(BigDecimal.valueOf(five * 1500000L));
    totalReturnAmount = totalReturnAmount.add(BigDecimal.valueOf(six * 2000000000L));
    this.rate = lottos.findRateOfReturn(totalReturnAmount);
    return lottos.findRateOfReturn(totalReturnAmount);
  }

  public void findMatches(Integer matchesNumber) {
    if (matchesNumber == 3) {
      findThreeMatches();
    } else if (matchesNumber == 4) {
      findFourMatches();
    } else if (matchesNumber == 5) {
      findFiveMatches();
    } else if (matchesNumber == 6) {
      findSixMatches();
    }
  }

  private void findThreeMatches() {
    three++;
  }

  private void findFourMatches() {
    four++;
  }

  private void findFiveMatches() {
    five++;
  }

  private void findSixMatches() {
    six++;
  }

  public Integer getThreeMatches() {
    return three;
  }

  public Integer getFourMatches() {
    return four;
  }

  public Integer getFiveMatches() {
    return five;
  }

  public Integer getSixMatches() {
    return six;
  }

  public BigDecimal getRate() {
    return rate;
  }

}
