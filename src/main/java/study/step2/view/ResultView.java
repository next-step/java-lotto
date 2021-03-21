package study.step2.view;

import java.util.List;

import study.step2.domain.Lotto;
import study.step2.domain.LottoRank;
import study.step2.domain.LottoWin;

public class ResultView {
    private final static String MESSAGE_PURCHASE_COUNT = "개를 구입하셨습니다.";
    private final static String MESSAGE_WIN_RESULT = "당첨 통계\n---------";

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
            System.out.println(win.getHit() + "개 일치 (" + win.getAmount() + "원) - " + lottoWin.getWin().get(win) + "개");
        }
    }
}
