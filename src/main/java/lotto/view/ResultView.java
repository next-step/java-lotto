package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public abstract class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos lottos) {
        int purchasedLotto = lottos.numberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.toString());
        }
        ResultView.println("");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", rank.matchedCount(), rank.winningCount(), lottoResult.numberOfLotto(rank.matchedCount()));
        }
    }

}
