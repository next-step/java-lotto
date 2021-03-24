package lotto.view;

import lotto.domain.Number;
import lotto.domain.*;

import java.util.stream.Collectors;

public class ResultView {
    private static final String RANK_FORMAT_STRING =
            "당첨 통계\n"
                    + "---------\n"
                    + "3개 일치 (5000원)- %d개\n"
                    + "4개 일치 (50000원)- %d개\n"
                    + "5개 일치 (1500000원)- %d개\n"
                    + "6개 일치 (2000000000원)- %d개\n";
    private static final String YIELD_FORMAT_STRING =
            "총 수익률은 %.3f입니다.\n";


    public static void printLottoNumber(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String str = lotto.getLotto().stream()
                    .map(Number::getNumToString)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + str + "]");
        }
    }

    public static void printLottoResult(Prize prize) {

        System.out.format(RANK_FORMAT_STRING,
                prize.getPrize().get(Rank.FOURTH),
                prize.getPrize().get(Rank.THIRD),
                prize.getPrize().get(Rank.SECOND),
                prize.getPrize().get(Rank.FIRST));
        System.out.println("================");
    }

    public static void printLottoYield(Stats stats, int payLotto) {
        double yield = stats.calYield(payLotto);
        System.out.format(YIELD_FORMAT_STRING, yield);
    }
}
