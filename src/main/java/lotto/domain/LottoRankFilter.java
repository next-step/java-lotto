package lotto.domain;

public interface LottoRankFilter {
  boolean filter(boolean bonusBall, Money winnerMoney);
}
