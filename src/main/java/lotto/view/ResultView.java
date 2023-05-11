package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;

public class ResultView {

    private static final String RESULT_GAME = "당첨 통계\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_INFO = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoNumber(Lottos lottos) {
        for (Lotto lottoNumber : lottos.getLottos()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoStatistic(LottoResults lottoResults) {
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

    public static void printWinningProfit(LottoResults lottoResults, int price) {
        StringBuilder stringBuilder = new StringBuilder();
        String format = String.format(STATISTICS_INFO
                , (double) price / LottoResults.getTotalPrice(lottoResults));
        stringBuilder.append(format);
        System.out.println(stringBuilder);
    }

}
