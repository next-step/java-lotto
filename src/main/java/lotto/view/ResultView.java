package lotto.view;

import lotto.domain.LottoShop;
import lotto.domain.LottoNumber;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;

public class ResultView {

    private static final String RESULT_GAME = "당첨 통계\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_INFO = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printLottoNumber() {
        for (LottoNumber lottoNumber : LottoShop.lottos) {
            System.out.println(lottoNumber);
        }
    }

    public void printLottoStatistic(LottoResults lottoResults) {
        System.out.println(RESULT_GAME);
        System.out.println(printLottoPrizes(lottoResults));
    }

    private static StringBuilder printLottoPrizes(LottoResults lottoResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            stringBuilder.append(String.format(STATISTICS_STATUS
                    ,lottoResult.getHit()
                    ,lottoResult.getReward()
                    ,lottoResult.getNumberOfWin()));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static void printWinningProfit(LottoResults lottoResults, int lottoCount) {
        StringBuilder stringBuilder = new StringBuilder();
        int totalPrice = 0;
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            if(lottoResult.getTotalPrice() != 0) {
                int totalPrice1 = lottoResult.getTotalPrice();
                totalPrice += totalPrice1;
            }
        }
        stringBuilder.append(String.format(STATISTICS_INFO ,(lottoCount * 1000.0) / totalPrice));
        System.out.println(stringBuilder);

    }

}
