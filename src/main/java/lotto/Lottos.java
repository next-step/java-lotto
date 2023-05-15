package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;
  private static final int PURCHASE_MIN_AMOUNT = 1000;
  private static final int LOTTO_PRICE = 1000;

  public Lottos() {
    lottos = new LinkedList<>();
  }

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> buy(int purchaseAmount) {
    validMinAmount(purchaseAmount);
    int purchaseNumber = purchaseAmount / LOTTO_PRICE;

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    for (int i = 0; i < purchaseNumber; i++) {
      lottos.add(new Lotto(lottoNumberGenerator.create()));
    }

    return this.lottos;
  }

  public MatchesStatus findWinner(WinningNumbers winningNumbers, BonusBall bonusBall) {
    MatchesStatus matchesStatus = new MatchesStatus();
    for (Lotto lotto : lottos) {
      matchesStatus.addMatchesCount(findMatches(lotto, winningNumbers, bonusBall));
    }
    matchesStatus.findRateOfReturn(this);
    return matchesStatus;
  }

  private Matches findMatches(Lotto lotto, WinningNumbers winningNumbers, BonusBall bonusBall) {
    int matchesNumber = lotto.countMatchesNumber(winningNumbers);
    if (isFiveMatches(matchesNumber) && lotto.has(bonusBall)) {
      return Matches.MATCH_FIVE_AND_BONUS;
    }
    return Matches.getMatches(matchesNumber);
  }

  private boolean isFiveMatches(int matchesNumber) {
    return matchesNumber == 5;
  }

  private void validMinAmount(int purchaseAmount) {
    if (purchaseAmount < PURCHASE_MIN_AMOUNT) {
      throw new IllegalArgumentException();
    }
  }

  public BigDecimal findRateOfReturn(BigDecimal totalReturnAmount) {
    return totalReturnAmount.divide(new BigDecimal(lottos.size() * LOTTO_PRICE), 2,
        RoundingMode.FLOOR);
  }
}
