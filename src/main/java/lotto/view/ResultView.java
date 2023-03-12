package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.WinningStatistics;

import java.util.List;

public class ResultView {
    public static void printBuyCountForPrint(LottoGame lottoGame) {
        System.out.println(lottoGame.getBuyCountForPrint());
        for (List<Integer> allLottoNumber : lottoGame.getAllLottoNumbers()) {
            System.out.println(allLottoNumber);
        }
        System.out.println();
    }

    public static void printLottoResult(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계\n---------");
        System.out.println(statistics.printInformation());
        System.out.println("총 수익률은 " + statistics.getTotalRateOfReturnForPrint() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
