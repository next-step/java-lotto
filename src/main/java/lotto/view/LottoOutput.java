package lotto.view;

import lotto.model.*;
import lotto.model.constants.Dividend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoOutput {
    public static final int MIN_CORRECT_COUNT = 3;
    public static final int MAX_CORRECT_COUNT = 6;

    public void viewLottoCount(Lottos lottos) {
        System.out.println(lottos.lottoCount() + "개를 구매했습니다.");
    }

    public void viewLottosDetail(Lottos lottos) {
        for (Lotto lotto : lottos.lottoList()) {
            System.out.println("[" + getLottoDetail(lotto) + "]");
        }
        System.out.println();
    }

    private String getLottoDetail(Lotto lotto) {
        List<String> list = new ArrayList<>();
        for (PositiveNumber number : lotto.numbers()) {
            list.add(Integer.toString(number.number()));
        }
        return String.join(", ", list);
    }

    public void viewTotalIncomeRatio(Lottery lottery) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottery.getInvestment()) + "입니다.");
    }

    public void viewCorrectLottos(Lottery lottery) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int correctCount = MIN_CORRECT_COUNT; correctCount <= MAX_CORRECT_COUNT; correctCount++) {
            viewCorrectLotto(Dividend.valueOf(correctCount, false), lottery.checkForWin(correctCount, false));
            viewSecondCorrectLotto(correctCount, lottery);
        }
    }

    private void viewSecondCorrectLotto(int correctCount, Lottery lottery) {
        if (Dividend.SECOND.correctCount() == correctCount) {
            System.out.println(correctCount + "개 일치, 보너스 볼 일치(" + Dividend.SECOND.dividendAmount() + "원) - " + lottery.checkForWin(correctCount, true) + "개");
        }
    }

    public void viewCorrectLotto(Dividend dividend, int count) {
        System.out.println(dividend.correctCount() + "개 일치 (" + dividend.dividendAmount() + "원) - " + count + "개");
    }
}
