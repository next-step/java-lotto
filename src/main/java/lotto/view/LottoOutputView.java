package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;

import java.text.DecimalFormat;
import java.util.List;

public class LottoOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printWinningStats(LottoResults lottoResults) {
        System.out.printf("당첨 통계\n---------\n%s", lottoResults);
    }

    public static void printWinningRatio(double winningRatio) {
        System.out.printf("총 수익률은 %s입니다.", new DecimalFormat("#.##").format(winningRatio));
    }
}
