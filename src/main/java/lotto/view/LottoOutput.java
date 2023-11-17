package lotto.view;

import lotto.model.*;
import lotto.model.constants.Dividend;

public class LottoOutput {
    public static final int MIN_CORRECT_COUNT = 3;
    public static final int MAX_CORRECT_COUNT = 6;

    public void viewLottoCount(Lottos lottos) {
        System.out.println(lottos.lottoCount() + "개를 구매했습니다.");
    }

    public void viewLottoDetail(Lottos lottos) {
        for (Lotto lotto : lottos.lottoList()) {
            System.out.println(lotto.numbers());
        }
        System.out.println();
    }

    public void viewTotalIncomeRatio(Lottery lottery) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottery.getInvestment()) + "입니다.");
    }

    public void viewCorrectLottos(Lottery lottery) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = MIN_CORRECT_COUNT; i <= MAX_CORRECT_COUNT; i++) {
            viewCorrectLotto(i, lottery.checkForWin(i));
        }
    }

    public void viewCorrectLotto(int correctCount, int count) {
        System.out.println(correctCount + "개 일치 (" + Dividend.getDividend(correctCount).dividendAmount() + "원) - " + count + "개");
    }
}
