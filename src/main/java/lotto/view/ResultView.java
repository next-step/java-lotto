package lotto.view;

import static lotto.LottoRank.LOSE;

import java.util.Arrays;
import lotto.LottoRank;
import lotto.LottoResult;
import lotto.Lottos;

public class ResultView {

    public static void printLottosCount(int purchaseCount, Lottos lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
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

    public static void printReturnRate(int payed, LottoResult result) {
        System.out.println("총 수익률은 " + result.calculateReturnRate(payed) + " 입니다.");
    }

}
