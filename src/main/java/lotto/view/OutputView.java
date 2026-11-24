package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(OutputFormatter.formatPurchaseCount(lottos.size()));
        lottos.forEach(lotto -> System.out.println(OutputFormatter.formatLotto(lotto)));
    }

    public static void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        OutputFormatter.formatStatistics(result).forEach(System.out::println);
        System.out.println(OutputFormatter.formatProfitRate(result.getProfitRate()));
    }
}
