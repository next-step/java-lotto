package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningStatistics;

public class OutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + printLotto(lotto) + "]");
        }
    }

    private static String printLotto(Lotto lotto) {
        return String.join(",", lotto.getLottoNumbers().stream()
            .map(String::valueOf)
            .sorted()
            .toArray(String[]::new)
        );
    }

    public static void printWinningStatistics(int money, LottoWinningStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        statistics.generateFormattedReport()
            .forEach(System.out::println);

        System.out.println("총 수익률은" + statistics.getProfitRate(money) + "입니다.");
    }
}
