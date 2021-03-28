package step2.view;

import step2.domain.Number;
import step2.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    public static void printLottos(Lottos lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(prettyString(lotto));
        }
    }

    private static String prettyString(Lotto lotto) {
        return String.format("%s%s%s", "[",
                        lotto.getNumbers()
                                .stream()
                                .map(Number::getNumber)
                                .map(i -> String.valueOf(i))
                                .collect(Collectors.joining(", ")),
                "]");
    }

    public static void printStatistics(Lottos lottos, Lotto prizeLotto) {
        System.out.println("\n당첨통계");
        System.out.println("---------");
        System.out.println(prettyString(lottos, prizeLotto, Prize.THREE_MATCH));
        System.out.println(prettyString(lottos, prizeLotto, Prize.FOUR_MATCH));
        System.out.println(prettyString(lottos, prizeLotto, Prize.FIVE_MATCH));
        System.out.println(prettyString(lottos, prizeLotto, Prize.ALL_MATCH));
    }

    private static String prettyString(Lottos lottos, Lotto prizeLotto, Prize prize) {
        return String.format("%d개 일치 (%d원)- %d개", prize.getMatchCount(), prize.getAmount(),
                lottos.getPrizeCount(prizeLotto, prize));
    }

    public static void printRevenueRate(Lottos lottos, Lotto prizeLotto, Money amount) {
        double revenueRate = amount.getRevenueRate(lottos.getTotalPrizeAmount(prizeLotto));
        System.out.print("총 수익률은 " + String.format("%.2f", revenueRate) + "입니다.");
        if (revenueRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (revenueRate > 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
        }
    }
}
