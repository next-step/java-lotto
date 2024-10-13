package lottogame.ui;

import lottogame.domain.Lotto;
import lottogame.domain.Lottos;
import lottogame.domain.Rank;

import java.util.Map;

public final class LottoOutputView {

    private LottoOutputView() {
    }

    public static void printBuyAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().stream()
                    .map(n -> String.valueOf(n.getNumber()))
                    .collect(java.util.stream.Collectors.joining(", ", "[", "]")));
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winningResults.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("4개 일치 (50000원)- " + winningResults.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치 (1500000원)- " + winningResults.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningResults.getOrDefault(Rank.FIRST, 0) + "개");
    }

    public static void printPrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
                prizeRate,
                prizeRate < 1 ? "손해" : "이득");
    }


}
