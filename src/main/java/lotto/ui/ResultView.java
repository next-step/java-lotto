package lotto.ui;

import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import lotto.domain.result.GameResult;

public class ResultView {

  public static void printPurchase(Purchase purchase) {
    System.out.println(purchase);
  }

  public static void printResult(GameResult gameResult, Money purchaseAmount) {

    System.out.println("\n당첨 통계\n---------");
    System.out.println(gameResult);
    System.out.println("총 수익률은 " + gameResult.getProfitMessage(purchaseAmount));
  }

}
