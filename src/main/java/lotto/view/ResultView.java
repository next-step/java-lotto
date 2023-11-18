package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningEnum;

import java.math.BigDecimal;

public class ResultView {
    public static void purchaseCount(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void lottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void winningStaticsMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void winningStatics(int correctCount, int winningCount) {
        int winningAmount = WinningEnum.winningAmount(correctCount);
        System.out.println(correctCount + "개 일치 (" + winningAmount + "원) - " + winningCount + "개");
    }

    public static void rateOfReturn(BigDecimal rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
