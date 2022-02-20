package lotto.view;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoDescription;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.Money;

public class ResultView {

    private ResultView() {
    }

    public static void printMoney(final Money money) {
        System.out.println(money.getCount() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottoes lottos) {
        for (Lotto lotto : lottos.getLottoes()) {
            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }
        System.out.println();
    }

    public static void printLottoResults(LottoResult lottoResult, double yield) {
        System.out.println("\n당첨 통계\n" + "---------");
        for (LottoDescription lottoDescription : LottoDescription.toList()) {
            printLottoResult(lottoDescription, lottoResult.getCount(lottoDescription.getHash()));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private static void printLottoResult(LottoDescription lottoDescription, int lottoCount) {
        if (lottoDescription.isBonusNumber()) {
            System.out.println(
                lottoDescription.getMatchCount() + "개 일치, 보너스 볼 일치(" + lottoDescription.getWinning()
                    + ")원- " + lottoCount + "개");
            return;
        }
        System.out.println(
            lottoDescription.getMatchCount() + "개 일치 (" + lottoDescription.getWinning() + ")원- "
                + lottoCount + "개");
    }
}
