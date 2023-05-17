package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.result.Rank;

import java.util.Map;

public class ResultView {

    private static final String RESULT_GAME = "당첨 통계\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_INFO = "총 수익률은 %.2f 입니다.";

    public static void printLottoNumber(Lottos lottos) {
        for (Lotto lottoNumber : lottos.lottos) {
            System.out.println(lottoNumber);
        }
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoStatistic(LottoResult lottoResult) {
        System.out.println(RESULT_GAME);
        System.out.println(printLottoPrizes(lottoResult));
    }

    private static StringBuilder printLottoPrizes(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Rank, Long> rankLongEntry : lottoResult.getLottoResult().entrySet()) {
            stringBuilder.append(String.format(STATISTICS_STATUS,
                    rankLongEntry.getKey().getHit(),
                    rankLongEntry.getKey().getReward(),
                    rankLongEntry.getValue()));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    public static void printWinningProfit(LottoResult lottoResult, int payment) {
        System.out.printf((STATISTICS_INFO), (double) lottoResult.getTotalPrice() / payment);
    }

}
