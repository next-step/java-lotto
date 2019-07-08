package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoWin;

public class ResultView {
    public static void println(String message) {
        System.out.println(message);
    }

    public static void printResult(LottoResult result) {
        println("당첨 통계");
        println("---------");
        println(result.getResultOf(LottoWin.FIFTH));
        println(result.getResultOf(LottoWin.FOURTH));
        println(result.getResultOf(LottoWin.THIRD));
        println(result.getResultOf(LottoWin.SECOND));
        println(result.getResultOf(LottoWin.FIRST));
        println("총 수익률은 " + result.getProfitRate() + "입니다.");
    }
}
