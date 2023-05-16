package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResults;
import lotto.domain.result.Rank;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ResultView {

    private static final String RESULT_GAME = "당첨 통계\n---------";
    private static final String STATISTICS_STATUS = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_INFO = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoNumber(Lottos lottos) {
        for (Lotto lottoNumber : lottos.lottos) {
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
        Map<Rank, Long> data = lottoResults.groupingByLottoResult();
        StringBuilder stringBuilder = new StringBuilder();

        data.entrySet().stream().forEach(e -> {
            stringBuilder.append(String.format(STATISTICS_STATUS
                    , e.getKey().getHit()
                    , e.getKey().getReward()
                    , e.getValue()));
            stringBuilder.append("\n");
        });
        return stringBuilder;
    }

    public static void printWinningProfit(LottoResults lottoResults, int payment) {
        Map<Rank, Long> data = lottoResults.groupingByLottoResult();
        StringBuilder stringBuilder = new StringBuilder();
        AtomicLong totalPrice = new AtomicLong();

        data.entrySet().stream().forEach(e -> {
            Long totalPriceData = e.getKey().getReward() * e.getValue();
            if (totalPriceData != 0) {
                totalPrice.addAndGet(totalPriceData);
            }
        });

        String format = String.format(STATISTICS_INFO
                , (double) payment / totalPrice.get());
        stringBuilder.append(format);
        System.out.println(stringBuilder);
    }

}
