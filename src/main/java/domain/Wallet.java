package domain;

import static domain.Lotto.PRICE_PER_LOTTO;

public class Wallet {

  // 돈과 로또들을 갖는 지갑
  public static final String NOT_ENOUGH_MONEY = "로또를 구매하기에는 돈이 부족합니다. money = ";

  private Money money;
  private Lottos lottos;

  public Wallet(int moneyAmount) {
    this.money = new Money(moneyAmount);
    checkCanBuyAnyLotto();
    this.lottos = new Lottos();
  }

  public void buyAutoLottos() {
    if (!canBuyAnyLotto()) {
      return;
    }
    int lottoAmount = getLottoAmountCanBuyWithMoneyInWallet();
    spend(lottoAmount);
  }

  public void checkCanBuyAnyLotto() {
    if (canBuyAnyLotto()) {
      throw new IllegalArgumentException(NOT_ENOUGH_MONEY + this.money.getValue());
    }
  }
  private boolean canBuyAnyLotto() {
    return this.money.isLowerThan(PRICE_PER_LOTTO);
  }

  public void buyCustomLottos(Lottos customLottos) {
    int customLottoCount = customLottos.getLottos().size();
    this.money = this.money.subtract(PRICE_PER_LOTTO.multiply(customLottoCount));
    this.lottos.addLottos(customLottos);
  }

  private int getLottoAmountCanBuyWithMoneyInWallet() {
    return this.money.quotient(PRICE_PER_LOTTO);
  }

  private void spend(int lottoAmount) {
    Money totalAmountOfLottoPurchased = PRICE_PER_LOTTO.multiply(lottoAmount);
    this.money.subtract(totalAmountOfLottoPurchased);
    for (int i = 0; i < lottoAmount; i++) {
      this.lottos.addLotto(new Lotto());
    }
  }

  public Lottos getLottos() {
    return this.lottos;
  }

}