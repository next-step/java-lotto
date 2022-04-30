package lotto.view;

import lotto.model.Lottos;

public class OutputView {

  public static void outputCountPurchasedLotto(int purchasedLotto) {
    System.out.println(purchasedLotto + "개를 구매했습니다.");
  }

  public static void outputPurchasedLottoInfo(Lottos lottos) {
    System.out.println(lottos);
  }
}
