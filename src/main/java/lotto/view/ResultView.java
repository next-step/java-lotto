package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.LottoWallet;

import java.util.List;

public class ResultView {

    public static void printPurchasedLotteryAmount(int purchasedLotteryAmount) {
        System.out.println(purchasedLotteryAmount + "개를 구매했습니다.");
    }

    public static void printPurchasedLotteryNumbers(LottoWallet lottoWallet) {
        List<Lotto> lottos = lottoWallet.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printLotteryResult(LottoResult lottoResult) {
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("--------");

        int[] printRanks = {3, 4, 5, 6};
        for (int printRank : printRanks) {
            int prizeOf = lottoResult.getPrizeOf(printRank);
            int wonAmountOf = lottoResult.getWonAmountOf(printRank);
            System.out.println(printRank + "개 일치 (" + prizeOf + ") - " + wonAmountOf + "개");
        }

        System.out.printf("총 수익률은 %.2f 입니다.", lottoResult.getReturnRate());
    }

}
