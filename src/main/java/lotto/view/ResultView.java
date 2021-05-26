package lotto.view;

import java.math.BigDecimal;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWin;

public class ResultView {
    private final static String MESSAGE_PURCHASE_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "\n당첨 통계\n---------";
    private final static String MESSAGE_BONUS_BALL = ", 보너스 일치";
    private static final String MESSAGE_EMPTY = " ";

    public static void printPurchaseCount(int count) {
        System.out.println(count + MESSAGE_PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
                System.out.println(lotto.lottoNumbers());
            });
    }

    public static void printResult(LottoWin lottoWin) {
        System.out.println(MESSAGE_WIN_RESULT);
        for(LottoRank win : lottoWin.win().keySet()) {
            System.out.println(win.hit() +
                "개 일치" +
                printBonus(win) +
                "(" +
                win.amount() +
                "원) - " +
                lottoWin.win().get(win) +
                "개");
        }
    }

    private static String printBonus(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return MESSAGE_BONUS_BALL;
        }
        return MESSAGE_EMPTY;
    }

    public static void printProfit(BigDecimal profit) {
        System.out.println("총 수익률은 " +  profit + "입니다.");
    }
}
