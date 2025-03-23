package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoResult;
import lotto.model.LottoWallet;

public class OutputView {

    public static void printLottoWallet(LottoWallet wallet) {
        int size = wallet.getLottoCount();
        System.out.println(size + "개를 구매했습니다");
        for (Lotto lotto : wallet) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.getPrizeCount(LottoPrize.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + result.getPrizeCount(LottoPrize.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getPrizeCount(LottoPrize.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getPrizeCount(LottoPrize.FIRST) + "개");

        double returnRate = result.calculateReturnRate();

        String comment;
        if (returnRate == 0.0) {
            comment = "(평범하게 망했네요)";
        } else if (returnRate < 1) {
            comment = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        } else {
            comment = "(로또맞았네!)";
        }
        System.out.println("총 수익률은 " + result.calculateReturnRate() + "입니다." + comment);

    }

}
