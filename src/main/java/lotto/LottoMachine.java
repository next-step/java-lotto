package lotto;

import java.util.List;

public class LottoMachine {

  private static final int PRICE_PER_LOTTO = 1000;
  private static final String ERROR_INVALID_PURCHASE_AMOUNT =
      "금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.";

  public static List<Lotto> generateLottos(int money) {
    validateMoney(money);
    return LottoGenerator.generateLottos(money / PRICE_PER_LOTTO);
  }

  public static LottoResult generateResult(List<Lotto> lottos, Lotto winningNumbers, int money) {
    return new LottoResult(lottos, winningNumbers, money);
  }

  private static void validateMoney(int money) {
    if (money < PRICE_PER_LOTTO || money % PRICE_PER_LOTTO != 0) {
      throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
    }
  }

}
