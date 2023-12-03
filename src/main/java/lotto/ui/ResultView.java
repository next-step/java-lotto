package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class ResultView {

    public static void purchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(l -> System.out.println(l.toString()));
        System.out.println();
    }

    public static void result(Result result, int money) {
        System.out.println("\n당첨 통계"
            + "\n---------");

        System.out.println("3개 일치 (5000원)- " + result.result().get(Rank.FOURTH));
        System.out.println("4개 일치 (50000원)- " + result.result().get(Rank.THIRD));
        System.out.println("5개 일치 (1500000원)- " + result.result().get(Rank.SECOND));
        System.out.println("6개 일치 (2000000000원)- " + result.result().get(Rank.FIRST));
        System.out.println("총 수익률은 " + result.rateOfReturn(money) + "입니다.");
    }
}
