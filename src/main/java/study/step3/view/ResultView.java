package study.step3.view;

import java.math.BigDecimal;
import java.util.List;

import study.step3.domain.Lotto;
import study.step3.domain.LottoNumber;
import study.step3.domain.LottoRank;
import study.step3.domain.LottoWin;

public class ResultView {
    private final static String MESSAGE_PURCHASE_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "당첨 통계\n---------";
    private final static String MESSAGE_BONUS_BALL = ", 보너스 일치";
    private static final String MESSAGE_EMPTY = " ";

    public static void printPurchaseCount(int count) {
        System.out.println(count + MESSAGE_PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers());
        });
        System.out.println();
    }

    public static void printResult(LottoWin lottoWin) {
        System.out.println(MESSAGE_WIN_RESULT);
        for(LottoRank win : lottoWin.getWin().keySet()) {
            System.out.println(win.getHit() + "개 일치" + printBonus(win) + "(" + win.getAmount() + "원) - " + lottoWin.getWin().get(win) + "개");
        }
    }

    private static String printBonus(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return MESSAGE_BONUS_BALL;
        }
        return MESSAGE_EMPTY;
    }

    public static void printProfit(BigDecimal profit) {
        System.out.println("총 수익률은 " +  String.format("%.2f", profit) + "입니다.");
    }
}
