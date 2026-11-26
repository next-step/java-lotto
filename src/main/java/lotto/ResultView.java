package lotto;

import java.util.Arrays;

public class ResultView {

    private static final double BREAK_EVEN_RATE = 1;

    public static void viewLottos(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void viewResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> viewPrize(prize, result.countOf(prize)));
        viewProfitRate(result.profitRate());
    }

    private static void viewPrize(Prize prize, int count) {
        System.out.println(prize.getMatchCount() + "개 일치 (" + prize.getMoney() + "원)- " + count + "개");
    }

    private static void viewProfitRate(double profitRate) {
        System.out.print("총 수익률은 " + profitRate + "입니다.");
        if (profitRate < BREAK_EVEN_RATE) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }
}
