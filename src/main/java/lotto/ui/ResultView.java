package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class ResultView {
    public static void purchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(l -> System.out.println(l.toString()));
        System.out.println();
    }

    public static void result(Rank rank, int money) {
        System.out.println("\n당첨 통계"
            + "\n---------");

        System.out.println("3개 일치 (5000원)- " + rank.fourthCount);
        System.out.println("4개 일치 (50000원)- " + rank.thirdCount);
        System.out.println("5개 일치 (1500000원)- " + rank.secondCount);
        System.out.println("6개 일치 (2000000000원)- " + rank.firstCount);
        System.out.println("총 수익률은 " + rank.rateOfReturn(money) + "입니다.");
    }
}
