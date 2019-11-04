package lotto.view;

import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatus;

public class ResultView {

    public static void printTotalLottoCount(final int totalCount) {
        System.out.println(totalCount + "개를 구매했습니다.");
    }

    public static void printIssuedLottos(final IssuedLottos issuedLottos) {
        for (Lotto issuedLotto : issuedLottos.findAllIssuedLottos()) {
            System.out.println(issuedLotto.findNumbers());
        }
    }

    public static void printWinningStatus(final WinningStatus winningStatus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningStatus.getCountOfRankFor(Rank.FIFTH));
        System.out.println("4개 일치 (50000원) - " + winningStatus.getCountOfRankFor(Rank.FOURTH));
        System.out.println("5개 일치 (1500000원) - " + winningStatus.getCountOfRankFor(Rank.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningStatus.getCountOfRankFor(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원) - " + winningStatus.getCountOfRankFor(Rank.FIRST));
    }

    public static void printResult(final double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 때문에 결과적으로 " + (rate >= 1 ? "이득" : "손해") + "라는 의미임)");
    }
}
