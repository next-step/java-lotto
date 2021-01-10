package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoStatistics;

import java.util.List;

public class ResultView {

    private static int totalWinningAmount;

    public static void printBuyLottoNumber(List<Lotto> buyLotto, int manualSize, int autoSize) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다." + System.lineSeparator(), manualSize, autoSize);
        System.out.println(buyLotto.toString());
    }

    public static void statisticsPrint(LottoStatistics lottoStatistics, LottoMoney lottoMoney) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printWinners(lottoStatistics);
        rateOfReturn(lottoStatistics, lottoMoney);
    }

    private static void rateOfReturn(LottoStatistics lottoStatistics, LottoMoney lottoMoney) {
        System.out.printf("총 수익률은 %s 입니다.", lottoStatistics.rateOfReturn(totalWinningAmount, lottoMoney.getCoin() * 1000));
    }

    private static void printWinners(LottoStatistics lottoStatistics) {
        lottoStatistics.getMatchResult()
                .forEach((key,value) -> {
                    System.out.printf("%s (%d) - %d개" + System.lineSeparator(), key.getMessage(), key.getPrize(), value);
                    totalWinningAmount += key.getPrize() * value;
                });
    }
}
