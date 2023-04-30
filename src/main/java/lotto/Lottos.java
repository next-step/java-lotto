package lotto;

import java.util.LinkedList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;
  public static final int LOTTO_PRICE = 1000;

  public Lottos() {
    lottos = new LinkedList<>();
  }

  public List<Lotto> buy(int purchaseAmount) {
    valid(purchaseAmount);
    int purchaseNumber = purchaseAmount / LOTTO_PRICE;

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    lottoNumberGenerator.init();
    for (int i = 0; i < purchaseNumber; i++) {
      Lotto lotto = lottoNumberGenerator.create();
      lottos.add(lotto);
    }

    return this.lottos;
  }

  private void valid(int purchaseAmount) {
    if (purchaseAmount < 1000) {
      throw new IllegalArgumentException();
    }
  }

}
