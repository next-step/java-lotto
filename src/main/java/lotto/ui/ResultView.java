package lotto.ui;

import lotto.application.LottoIssueResponse;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}

    public static void printLottos(LottoIssueResponse response) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
                response.sizeAutoLottos(),
                response.sizeManualLottos()));

        Lottos lottos = response.getLottos();

        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.getLotto(i));
        }
    }

    private static void printLotto(Lotto lotto) {
        List<String> numbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String numbersStr = String.join(",", numbers);
        System.out.println(String.format("[%s]", numbersStr));
    }

    public static void printResults(LottoResults results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Rank> resultViewRanks = Rank.getResultViewRanks();
        for (Rank r : resultViewRanks) {
            printResult(results, r);
        }

        System.out.println(String.format("총 수익률은 %.2f입니다.", results.getProfitRate()));
    }

    private static void printResult(LottoResults results, Rank r) {
        String msg = String.format("%d개 일치%s (%d원)- %d개",
                r.getMatchedCount(),
                r.getMatchedBonusCount() > 0 ? ", 보너스 볼 일치" : "",
                r.getPrizeMoney(),
                results.getCounts(r));

        System.out.println(msg);
    }
}
