package study.step4.view;

import java.math.BigDecimal;

import study.step4.domain.LottoRank;
import study.step4.domain.LottoTicketCount;
import study.step4.domain.LottoWin;
import study.step4.domain.Lottos;

public class ResultView {
    private final static String MESSAGE_PURCHASE = "구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "\n당첨 통계\n---------";
    private final static String MESSAGE_BONUS_BALL = ", 보너스 일치";
    private final static String MESSAGE_EMPTY = " ";

    public static void printPurchaseLottoCount(LottoTicketCount autoCount, LottoTicketCount manualCount) {
        System.out.println("수동으로 " + manualCount.getLottoTicketCount() + "장, 자동으로 " + autoCount.getLottoTicketCount() + "장을 " + MESSAGE_PURCHASE);
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream()
            .forEach(lotto -> {
                System.out.println(lotto.getLottoNumbers());
            });
    }

    public static void printResult(LottoWin lottoWin) {
        System.out.println(MESSAGE_WIN_RESULT);
        for(LottoRank win : lottoWin.getWin().keySet()) {
            System.out.println(win.getHit() + "개 일치" + printBonus(win) + "(" + win.getMoney() + "원) - " + lottoWin.getWin().get(win) + "개");
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
