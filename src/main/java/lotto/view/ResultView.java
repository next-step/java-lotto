package lotto.view;

import java.math.BigDecimal;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWin;

public class ResultView {
    private final static String MESSAGE_PURCHASE_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "\n당첨 통계\n---------";

    public static void printPurchaseCount(int count) {
        System.out.println(count + MESSAGE_PURCHASE_COUNT);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> {
                System.out.println(lotto.lottoNumbers());
            });
    }

    public static void printResult(LottoWin lottoWin) {
        System.out.println(MESSAGE_WIN_RESULT);
        for(LottoRank win : lottoWin.win().keySet()) {
            System.out.println(win.hit() + "개 일치 (" + win.amount() + "원) - " + lottoWin.win().get(win) + "개");
        }
    }

    public static void printProfit(int payment, LottoWin lottoWin) {
        System.out.println("총 수익률은 " +  String.format("%.2f", ((double) lottoWin.sum() / payment)) + "입니다.");
    }
}
