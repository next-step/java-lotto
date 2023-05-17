package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class Lottos {

  private final List<AutoLotto> autoLottos;
  private List<ManualLotto> manualLottos;

  private static final int PURCHASE_MIN_AMOUNT = 1000;
  private static final int LOTTO_PRICE = 1000;

  public Lottos() {
    autoLottos = new LinkedList<>();
    manualLottos = new LinkedList<>();
  }

  public Lottos(List<AutoLotto> lottos) {
    this.autoLottos = lottos;
  }

  public void buyAutoLotto(int purchaseAmount, int manualPurchaseAmount) {
    validMinAmount(purchaseAmount);
    validManualAmount(purchaseAmount, manualPurchaseAmount * LOTTO_PRICE);
    int purchaseNumber = (purchaseAmount / LOTTO_PRICE) - manualPurchaseAmount;

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    for (int i = 0; i < purchaseNumber; i++) {
      autoLottos.add(new AutoLotto(lottoNumberGenerator.create()));
    }
  }

  public MatchesStatus findWinner(WinningNumbers winningNumbers, BonusBall bonusBall) {
    MatchesStatus matchesStatus = new MatchesStatus();
    for (AutoLotto lotto : autoLottos) {
      matchesStatus.addMatchesCount(findMatches(lotto, winningNumbers, bonusBall));
    }
    matchesStatus.findRateOfReturn(this);
    return matchesStatus;
  }

  private Matches findMatches(AutoLotto lotto, WinningNumbers winningNumbers, BonusBall bonusBall) {
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
      throw new IllegalArgumentException("로또 구매 금액은 1000원 이상이어야 합니다.");
    }
  }

  private void validManualAmount(int purchaseAmount, int manualPurchaseAmount) {
    if (manualPurchaseAmount > purchaseAmount) {
      throw new IllegalArgumentException("수동 구매는 로또 구매 개수보다 클 수 없습니다.");
    }
  }

  public BigDecimal findRateOfReturn(BigDecimal totalReturnAmount) {
    return totalReturnAmount.divide(new BigDecimal(autoLottos.size() * LOTTO_PRICE), 2,
        RoundingMode.FLOOR);
  }

  public void addManualLotto(ManualLotto manualLotto) {
    manualLottos.add(manualLotto);
  }

  public List<AutoLotto> getAutoLottos() {
    return autoLottos;
  }

  public List<ManualLotto> getManualLottos() {
    return manualLottos;
  }
}
