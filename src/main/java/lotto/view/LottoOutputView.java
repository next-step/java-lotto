package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

import java.util.Collections;

public class LottoOutputView {

    public static void printPurchaseNumber(int purchaseNumber){
        System.out.println(purchaseNumber + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto: lottos.getLottos()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        Collections.sort(lotto.getLottoNumbers());
        System.out.println(lotto);
    }

    public static void printLottosResult(LottoResults results) {
        System.out.println("당첨통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            printRank(rank ,results.findRankResult(rank));
        }
        printProfit(results);

    }

    private static void printProfit(LottoResults results) {
        double profitRate = (double) results.totalPrizeMoney() / ((double) results.countTotalLotto()* 1000);
        System.out.println("총 수익률은 "+String.format("%.2f", profitRate)+"입니다.");
    }

    private static void printRank(LottoRank rank, int rankResult) {
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrizeMoney() + "원) - " + rankResult + "개");

    }
}
