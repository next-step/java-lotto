package lotto.view;

import lotto.constant.LottoRank;
import lotto.domain.LottoRankStatistics;
import lotto.domain.Lottos;

public class ResultView {
    public static final double PROFIT_STANDARD = 1.0;

    public void printLottosNumber(Lottos lottos, int manualLottoCount) {
        System.out.println("");
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, lottos.getSize() - manualLottoCount);
        for (int i = 0; i < lottos.getSize(); i++) {
            System.out.println(lottos.getLottoNumbers(i).toString());
        }
    }

    public void printStatisticsResult(LottoRankStatistics lottoStatistics) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank rank : LottoRank.valuesWithWinningRank()) {
            String message = getMessageByRank(rank);
            System.out.printf(message, rank.getCountOfMatch(), rank.getWinningMoney()
                    , lottoStatistics.getLottoCountByRank(rank));
        }
    }

    public void printRateOfReturnResult(LottoRankStatistics lottoStatistics) {
        String resultRateOfReturnMessage = "";
        String rateOfReturn = lottoStatistics.calculateRateOfReturn();
        if (Double.parseDouble(rateOfReturn) < PROFIT_STANDARD) {
            resultRateOfReturnMessage = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.printf("총 수익률은 %s입니다.%s \n", rateOfReturn, resultRateOfReturnMessage);
    }

    private String getMessageByRank(LottoRank rank) {
        if (rank.equals(LottoRank.SECOND)) {
            return "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
        }
        return "%d개 일치 (%d원)- %d개\n";
    }
}
