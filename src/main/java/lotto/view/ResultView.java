package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningGrade;
import lotto.domain.WinningStatistic;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoNumber(List<Lotto> lotties){
        System.out.println(lotties.size() + "개를 구매했습니다.");
        lotties.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void showResult(WinningStatistic winningStatistic, int purchasePrice){

        Map<Integer, WinningGrade> winningResults = winningStatistic.getWinningGrades();
        System.out.println("당첨 통계");
        System.out.println("--------");
        winningResults.values().forEach(winningGrade ->
                System.out.println(winningGrade.getMatchingCount()
                        + "개 일치 (" + winningGrade.getWinningPrice() + ") - "
                        + winningGrade.getCount() + "개"));

        String profitOrLoss = winningStatistic.totalIncomeRate(purchasePrice) >= 1 ? "이익" : "손해";

        System.out.println("총 수익률은 " + winningStatistic.totalIncomeRate(purchasePrice) + "입니다." +
                "(기준이 1이기 때문에 결과적으로 " + profitOrLoss + "라는 의미임)");
    }
}
