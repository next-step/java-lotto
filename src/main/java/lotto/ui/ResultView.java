package lotto.ui;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.Money;
import lotto.domain.result.GameResult;

public class ResultView {

  public static void printPurchase(LottoTickets tickets) {
    System.out.println(tickets);
  }

  public static void printResult(GameResult gameResult, Money purchaseAmount) {

    System.out.println("\n당첨 통계\n---------");
    System.out.println(gameResult);
    System.out.println("총 수익률은 " + gameResult.getProfitMessage(purchaseAmount));
  }

}
