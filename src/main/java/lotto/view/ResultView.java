package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningGrade;
import lotto.domain.WinningPrice;
import lotto.domain.WinningStatistic;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoNumber(List<Lotto> lotties){
        System.out.println(lotties.size() + "개를 구매했습니다.");
        lotties.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void showResult(WinningStatistic winningStatistic, int purchasePrice){

        Map<WinningPrice, WinningGrade> winningResults = winningStatistic.getWinningGrades();
        System.out.println("당첨 통계");
        System.out.println("--------");

        winningResults.values().forEach(winningGrade ->{
            String message = String.format("%d개 일치(%d) - %d개", winningGrade.getMatchingCount()
                    , winningGrade.getWinningPrice(), winningGrade.getCount());
            System.out.println(message);
        });

        String profitOrLoss = winningStatistic.totalIncomeRate(purchasePrice) >= 1 ? "이익" : "손해";

        System.out.println(String.format("총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                winningStatistic.totalIncomeRate(purchasePrice), profitOrLoss));
    }
}
