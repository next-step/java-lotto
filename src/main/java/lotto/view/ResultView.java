package lotto.view;

import lotto.domain.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {


    public static void printPurchaseMethodMessage(LottoPurchaseMethod lottoPurchaseMethod){
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                lottoPurchaseMethod.getManualCount(), lottoPurchaseMethod.autoCount());
    }

    public static void printLottoNumber(List<Lotto> lotties){
        lotties.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void showResult(WinningStatistic winningStatistic, int purchasePrice){

        Map<WinningPrice, WinningGrade> winningResults = winningStatistic.getWinningGrades();
        System.out.println("당첨 통계");
        System.out.println("--------");

        winningResults.values().stream()
                .filter(winningGrade -> winningGrade.isWinningGrade())
                .sorted(Comparator.comparing(WinningGrade::getWinningPrice))
                .forEach(winningResult -> {
                    String message = MessageGenerator.generate(winningResult);
                    System.out.println(message);
                });


        String profitOrLoss = winningStatistic.totalIncomeRate(purchasePrice) >= 1 ? "이익" : "손해";

        System.out.println(String.format("총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                winningStatistic.totalIncomeRate(purchasePrice), profitOrLoss));
    }
}
