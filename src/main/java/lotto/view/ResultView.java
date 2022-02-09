package lotto.view;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.count.Count;
import lotto.domain.lotto.count.ManualCount;
import lotto.domain.lotto.number.Number;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(final ManualCount manualCount, final Count autoCount) {
        System.out.println("\n수동으로 " + manualCount.getCountValue() + "장, 자동으로 "+ autoCount.getValue() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLotto().getNumbersValue().stream().map(Number::getValue).toArray()));
        }
        System.out.println();
    }

    public static void printLottoResults(Map<LottoResult, Integer> lottoResults, double yield) {
        System.out.println("\n당첨 통계\n" + "---------");
        lottoResults.forEach((ResultView::printLottoResult));
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private static void printLottoResult(LottoResult lottoResult, Integer count) {
        if (lottoResult.isBonusNumber()) {
            System.out.println(
                lottoResult.getMatchCount() + "개 일치, 보너스 볼 일치(" + lottoResult.getWinning() + ")원- " + count + "개");
            return;
        }
        System.out.println(
            lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getWinning() + ")원- " + count + "개");
    }
}
