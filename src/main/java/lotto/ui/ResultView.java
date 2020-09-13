package lotto.ui;

import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

public class ResultView {

    private ResultView() {}

    public static void showTickets(LottoBundle bundle) {
        bundle.getTickets()
                .stream()
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
                .map(prize -> mapToString(prize, result.getCountOfPrize(prize)))
                .reduce("", String::concat);
    }

    private static String mapToString(Prize key, long count) {
        String format = "%d개 일치 (%d원) - %d개\n";
        if (key.equals(Prize.SECOND)) {
            format = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
        }
        return String.format(format, key.getMatchCount(), key.getReward(), count);
    }
}
