package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningInformation;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public static void printResult(final Map<WinningInformation, Long> lottoResult, final double profit) {
        System.out.println("\n당첨 통계");
        System.out.println("-".repeat(10));
        lottoResult.forEach((key, value) -> {
            System.out.println(resultMessage(key, value));
        });
        System.out.printf("총 수익률은 %.2f입니다.", profit);
    }

    private static String resultMessage(final WinningInformation wi, final Long count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d개 일치", wi.getCountOfMatchedNumber()));
        if (wi.isContainedBonus()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(String.format(" (%d원)- %d개", wi.getPrizeMoney(), count));

        return stringBuilder.toString();
    }
}
