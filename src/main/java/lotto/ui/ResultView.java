package lotto.ui;

import java.util.List;
import java.util.Map;
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

        for (Map.Entry<Rank, Integer> element : result.result().entrySet()) {
            if (element.getKey().equals(Rank.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d\n", element.getKey().matchCount(),
                    element.getKey().prizeAmount(), element.getValue());
                continue;
            }
            System.out.printf("%d개 일치 (%d원)- %d\n", element.getKey().matchCount(),
                element.getKey().prizeAmount(), element.getValue());
        }

        System.out.println("총 수익률은 " + result.rateOfReturn(money) + "입니다.");
    }
}
