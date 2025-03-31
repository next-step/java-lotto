package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.vo.LottoStatisticsValue;
import lotto.domain.LottoStatistics;

import static java.util.Collections.reverse;

public class OutputView {
    private static final String RESULT_FORMAT = "%s - %d개";
    private static final String PROFIT_RATE_FORMAT = "%.2f";

    public static void printLottoCount(int lottoManualCount, int lottoAutoCount) {
        System.out.println("수동으로 " + lottoManualCount + "장, 자동으로 " + lottoAutoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + printLotto(lotto) + "]");
        }
    }

    private static String printLotto(Lotto lotto) {
        return String.join(",", lotto.getLottoNumbers().stream()
            .map(String::valueOf)
            .toArray(String[]::new)
        );
    }

    public static void printWinningStatistics(int money, LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoStatisticsValue> report = statistics.getLottoStatisticsDTOs();
        reverse(report);
        report.stream()
            .map(dto -> String.format(RESULT_FORMAT, dto.getPrizeLevel().getMessage(), dto.getCount()))
            .forEach(System.out::println);

        String profitRate = String.format(PROFIT_RATE_FORMAT, statistics.getProfitRate(money));
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
