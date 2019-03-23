package lotto.domain;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  public static int buy(Money insertMoney) {
    return insertMoney.buy(LOTTO_AMOUNT);
  }
}
