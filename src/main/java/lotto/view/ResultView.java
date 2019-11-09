package lotto.view;

import lotto.domain2.Lotto;
import lotto.domain2.Lottos;
import lotto.domain2.Rank;
import lotto.domain2.WinningLottos;

public class ResultView {

    public static void printLottoCount(final int totalDirectLottoCount, final int totalAutoLottoCount) {
        System.out.println(String.format("수동으로 %s장, 자동으로 %s장을 구매했습니다.", totalDirectLottoCount, totalAutoLottoCount));
    }

    public static void printLottos(final Lottos lottos) {
        for (Lotto lotto : lottos.findAllLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatus(final WinningLottos winningLottos) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningLottos.getCountOf(Rank.FIFTH));
        System.out.println("4개 일치 (50000원) - " + winningLottos.getCountOf(Rank.FOURTH));
        System.out.println("5개 일치 (1500000원) - " + winningLottos.getCountOf(Rank.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningLottos.getCountOf(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + winningLottos.getCountOf(Rank.FIRST));
    }

    public static void printResult(final double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 때문에 결과적으로 " + (rate >= 1 ? "이득이" : "손해") + "라는 의미임)");
    }
}
