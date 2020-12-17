package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinResult;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void showPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(numbers ->
                System.out.println("[" + numbers.toString() +"]"));
    }

    public static void showResults(WinResult winResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        winResults.getResults()
                .forEach((key, value) -> System.out.println(key.getDesc() + "- " + value + "개"));

        System.out.println("총 수익률은 " + winResults.getYield() + "입니다");
    }
}
