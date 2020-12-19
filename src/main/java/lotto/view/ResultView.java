package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinResult;

public class ResultView {
    private ResultView() {
    }

    public static void showPurchasedLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(lottos.toString());
    }

    public static void showResults(WinResult winResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        winResults.getResults()
                .forEach((key, value) -> System.out.println(key.getDesc() + "- " + value + "개"));

        System.out.println("총 수익률은 " + winResults.getYeild() + "입니다");
    }
}
