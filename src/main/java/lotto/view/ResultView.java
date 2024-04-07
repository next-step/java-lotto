package lotto.view;

import static lotto.LottoRank.LOSE;

import java.util.Arrays;
import lotto.LottoRank;
import lotto.LottoResult;
import lotto.Lottos;
import lotto.PurchaseAmount;

public class ResultView {

    public static void printLottosCount(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWinningResult(LottoResult result) {
        System.out.println("당첨 통계\n---------");

        Arrays.stream(LottoRank.values()).filter(rank -> rank != LOSE)
            .forEach(rank ->
                System.out.printf("%s 일치 (%s원) - %d개\n",
                    rank.getCount(),
                    rank.getPrize(),
                    result.countRank(rank)));
    }

    public static void printReturnRate(PurchaseAmount amount, LottoResult result) {
        System.out.println("총 수익률은 " + result.calculateReturnRate(amount.getTotal()) + " 입니다.");
    }

    public static void printPurchaseLottoByEachType(PurchaseAmount amount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
            amount.getManual(), amount.getAuto());
    }

}
