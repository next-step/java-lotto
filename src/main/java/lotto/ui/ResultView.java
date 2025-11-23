package lotto.ui;

import lotto.domain.lotto.Purchase;
import lotto.domain.result.GameResult;

public class ResultView {

  public static void printPurchase(Purchase purchase) {
    System.out.println(purchase);
  }

  public static void printResult(GameResult gameResult) {
    System.out.println(gameResult);
  }

}
