package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.result.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_GAME = "당첨 통계\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_INFO = "총 수익률은 %.2f 입니다.";

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottoCount(int menualCount, int automaticCount) {
        System.out.println("수동으로 " + menualCount + "장, 자동으로 " + automaticCount + "개를 구매했습니다.");
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
