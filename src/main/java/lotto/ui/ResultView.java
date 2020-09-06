package lotto.ui;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

public class ResultView {

    private ResultView() {}

    public static void showTickets(LottoBundle bundle) {
        System.out.printf("%d개를 구매했습니다.\n", bundle.count());
        bundle.getTickets()
                .forEach(System.out::println);
    }

    public static void showDrawingResult(LottoResult result) {
        System.out.println("당첨 통계\n---------");
        System.out.println(formatResultByPrize(result));
        System.out.printf("총 수익률은 %.2f입니다.", result.profitRate());
    }

    private static String formatResultByPrize(LottoResult result) {
        return Prize.valuesOfWin()
                .stream()
                .map(prize -> mapToString(prize, result))
                .reduce("", String::concat);
    }

    private static String mapToString(Prize key, LottoResult result) {
        return String.format("%d개 일치 (%d원) - %d개\n",
                key.getMatchCount(),
                key.getReward(),
                result.getMatchCountByPrize(key)
        );
    }
}
