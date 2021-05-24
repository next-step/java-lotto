package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningAmounts;
import lotto.domain.WinningCounts;

public class ResultView {
    public static final double PROFIT_STANDARD = 1.0;

    public void printLottosNumber(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getSize());
        for (int i = 0; i < lottos.getSize(); i++) {
            System.out.println(lottos.getLotto(i).toString());
        }
        System.out.println("");
    }

    public void printStatisticsResult(LottoStatistics lottoStatistics) {
        WinningAmounts winningAmounts = new WinningAmounts();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = WinningCounts.WINNING_NUMBER_MINIMUM; i <= WinningCounts.WINNING_NUMBER_MAXIMUM; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, winningAmounts.getAmount(i)
                    , lottoStatistics.getCountOfLottoWithMatchingNumber(i));
        }
    }

    public void printRateOfReturnResult(Double rateOfReturn) {
        String resultRateOfReturnMessage = "";
        if (rateOfReturn < PROFIT_STANDARD) {
            resultRateOfReturnMessage = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.printf("총 수익률은 %s입니다.%s \n", String.format("%.2f", rateOfReturn), resultRateOfReturnMessage);
    }
}
