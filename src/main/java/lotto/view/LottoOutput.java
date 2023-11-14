package lotto.view;

import lotto.model.Lotto;
import lotto.model.constants.Dividend;
import lotto.util.LottoUtil;

import java.util.List;

public class LottoOutput {
    private LottoOutput() {

    }

    public static void viewLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void viewLottoDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void viewTotalIncomeRatio(long total, int purchaseAmount) {
        System.out.println("총 수익률은 " + String.format("%.2f", LottoUtil.getInvestment(total, purchaseAmount)) + "입니다.");
    }

    public static void viewLottoTotal(int correctCount, int count) {
        System.out.println(Dividend.getDividend(correctCount) + "" + count + "개");
    }
}
