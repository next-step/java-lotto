package Lotto.view;

import Lotto.constants.Rank;
import Lotto.domain.Lotto;
import Lotto.domain.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printQuantity(int quantity) {
        System.out.println(quantity+"개를 구매했습니다.");
    }

    private static String formatLotto(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(formatLotto(lotto)));
    }

    public static void printStats(Map<Rank, Integer> stats) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (Rank prize : Rank.values()) {
            int count = stats.getOrDefault(prize, 0);
            System.out.println(prize + " - " + count + "개");
        }
    }

    private static String formatRank(Rank rank) {
        String bonusMessage = rank.isMatchBonus() ? ", 보너스 볼 일치" : "";
        return rank.getCountOfMatch() + "개 일치" + bonusMessage + " (" + rank.getWinningMoney() + "원)";
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }
}
