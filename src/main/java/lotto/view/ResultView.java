package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.count.Count;
import lotto.domain.lotto.count.ManualCount;
import lotto.domain.lotto.number.Number;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(ManualCount manualCount, Count autoCount) {
        final String stringFormat = "\n수동으로 %s장, 자동으로 %s개를 구매했습니다.\n";
        System.out.printf(stringFormat, manualCount.getCountValue(), autoCount.getValue());
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lottoFormat(lotto));
        }
        System.out.println();
    }

    private static String lottoFormat(Lotto lotto) {
        return lotto.getNumbers().getNumbersValue().stream()
            .map(Number::getValue)
            .collect(Collectors.toList()).toString();
    }

    public static void printLottoResults(MatchResult lottoResults, double yield) {
        System.out.println("\n당첨 통계\n" + "---------");
        for (LottoResult lottoResult : lottoResults.getLottoResultSet()) {
            printLottoResult(lottoResult, lottoResults.getCount(lottoResult));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private static void printLottoResult(LottoResult lottoResult, Integer count) {
        if (lottoResult.equals(LottoResult.NO_MATCH)) {
            return;
        }
        System.out.print(lottoResult.getMatchCount() + "개 일치");
        if (lottoResult.isBonusNumber()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + lottoResult.getWinning() + ")원- " + count + "개");
    }
}
