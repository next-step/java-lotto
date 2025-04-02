package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoResult;
import lotto.model.LottoWallet;

public class OutputView {

    public static void printLottoWallet(LottoWallet wallet) {
        System.out.println("수동으로 " + wallet.manualLottoCount() + "장, 자동으로 " + wallet.autoLottoCount() + "개를 구매했습니다");
        for (Lotto lotto : wallet) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        LottoPrize[] prize = LottoPrize.values();
        for (int i = prize.length - 2; i >= 0; i--) {
            System.out.println(prize[i].comment() + "- " + result.getPrizeCount(prize[i]) + "개");
        }

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
