package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String PRIZE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoResult.Rank, Long> statistics = lottoResult.getStatistics();
        statistics.entrySet().stream().filter(entry -> entry.getKey() != LottoResult.Rank.MISS)
                .forEach(entry -> System.out.printf(PRIZE_FORMAT + "%n",
                        entry.getKey().getMatchCount(), entry.getKey().getPrize(),
                        entry.getValue()));
    }

    public void printProfitRate(double profitRate) {
        System.out.print(String.format(PROFIT_RATE_FORMAT, profitRate));

        if (profitRate < 1.0) {
            System.out.println(LOSS_MESSAGE);
        } else {
            System.out.println();
        }
    }
}
