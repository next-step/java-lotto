package lotto.view;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.Money;

public class ResultView {

    private ResultView() {
    }

    public static void printMoney(final Money money) {
        System.out.println(money.calculateCount() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottoes lottos) {
        for (Lotto lotto : lottos.getLottoes()) {
            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }
        System.out.println();
    }

    public static void printLottoResults(LottoResult lottoResult, double yield) {
        System.out.println("\n당첨 통계\n" + "---------");
        for (LottoGrade lottoGrade : LottoGrade.toList()) {
            printLottoResult(lottoGrade, lottoResult.getCount(lottoGrade.getName()));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    private static void printLottoResult(LottoGrade lottoGrade, int lottoCount) {
        if (lottoGrade.isBonusNumber()) {
            System.out.println(
                lottoGrade.getMatchCount() + "개 일치, 보너스 볼 일치(" + lottoGrade.getWinningPrice()
                    + ")원- " + lottoCount + "개");
            return;
        }
        System.out.println(
            lottoGrade.getMatchCount() + "개 일치 (" + lottoGrade.getWinningPrice() + ")원- "
                + lottoCount + "개");
    }
}
