package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinResult;

import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {
    }

    public static void showPurchasedLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printLottos(lottos);
    }

    public static void showPurchasedLottos(Lottos manualLottos, Lottos autoLottos) {
        System.out.println("수동으로 " + manualLottos.size() + "장, 자동으로 " + autoLottos.size() + "개를 구매했습니다.");
        printLottos(manualLottos);
        printLottos(autoLottos);
    }

    private static void printLottos(Lottos manualLottos) {
        manualLottos.getLottos().forEach(lotto -> {
            String numbers = lotto.getNumbers()
                    .stream()
                    .map(LottoNumber::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers + "]");
        });
    }

    public static void showResults(WinResult winResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        winResults.getResults()
                .forEach((key, value) -> System.out.println(key.getDesc() + "- " + value + "개"));

        System.out.println("총 수익률은 " + winResults.getYeild() + "입니다");
    }
}
