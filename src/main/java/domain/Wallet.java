package domain;

public class Wallet {

  // 돈과 로또들을 갖는 지갑
  public static final String NOT_ENOUGH_MONEY = "로또를 구매하기에는 돈이 부족합니다. money = %d";

  private int money;
  private Lottos lottos;

  public Wallet(int money) {
    this.money = money;
    this.lottos = new Lottos();
  }

  public void buyLottos() {
    if (this.money < Lotto.PRICE_PER_LOTTO) {
      throw new IllegalArgumentException(String.format(NOT_ENOUGH_MONEY, this.money));
    }

    int lottoAmount = getLottoAmountCanBuyWithMoneyInWallet();
    spend(lottoAmount);
  }

  private int getLottoAmountCanBuyWithMoneyInWallet() {
    return this.money / Lotto.PRICE_PER_LOTTO;
  }

  private void spend(int lottoAmount) {
    this.money -= lottoAmount * Lotto.PRICE_PER_LOTTO;
    for (int i = 0; i < lottoAmount; i++) {
      this.lottos.addLotto(new Lotto());
    }
  }

  public Lottos getLottos() {
    return this.lottos;
  }

}