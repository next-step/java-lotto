package lotto.ui;

import java.math.BigDecimal;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.Purchase;
import lotto.domain.result.GameResult;

public class ResultView {

  public static void printPurchase(Purchase purchase) {
    System.out.println(purchase);
  }

  public static void printTickets(LottoTickets tickets) {
    System.out.println(tickets);
  }

  public static void printResult(GameResult gameResult, Purchase purchase) {
    System.out.println("\n당첨 통계\n---------");
    System.out.println(gameResult);

    int totalPrize = gameResult.getTotalPrize();
    BigDecimal profitRate = purchase.calculateProfitRate(totalPrize);
    String explanation = profitRate.compareTo(BigDecimal.ONE) >= 0 ? "이익" : "손해";

    System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
        profitRate, explanation);
  }
}