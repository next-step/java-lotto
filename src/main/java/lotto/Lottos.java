package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;
  private static final int LOTTO_PRICE = 1000;

  public Lottos() {
    lottos = new LinkedList<>();
  }

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> buy(int purchaseAmount) {
    valid(purchaseAmount);
    int purchaseNumber = purchaseAmount / LOTTO_PRICE;

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    for (int i = 0; i < purchaseNumber; i++) {
      lottos.add(new Lotto(lottoNumberGenerator.create()));
    }

    return this.lottos;
  }

  public MatchesStatus findWinner(WinningNumbers winningNumbers) {
    MatchesStatus matchesStatus = new MatchesStatus();
    for (Lotto lotto : lottos) {
      matchesStatus.findMatches(winningNumbers.howManyMatches(lotto));
    }
    matchesStatus.findRateOfReturn(this);
    return matchesStatus;
  }

  private void valid(int purchaseAmount) {
    if (purchaseAmount < 1000) {
      throw new IllegalArgumentException();
    }
  }

  public BigDecimal findRateOfReturn(BigDecimal totalReturnAmount) {
    return totalReturnAmount.divide(new BigDecimal(lottos.size() * LOTTO_PRICE), 2,
        RoundingMode.FLOOR);
  }
}
