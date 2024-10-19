package lottogame.ui;

import lottogame.domain.lotto.Lotto;
import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.Lottos;
import lottogame.domain.lotto.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class LottoOutputView {

    private LottoOutputView() {
    }

    public static void printBuyAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private static String formatLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .sorted()
                .map(n -> String.valueOf(n.getNumber()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        getWinningRanks().forEach(rank -> printRankStatistics(rank, winningResults));
    }

    private static List<Rank> getWinningRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.isNone())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static void printRankStatistics(Rank rank, Map<Rank, Integer> winningResults) {
        System.out.printf("%s (%.0f원) - %d개%n",
                getMatchDescription(rank),
                rank.getPrizeMoney(),
                winningResults.getOrDefault(rank, 0));
    }

    private static String getMatchDescription(Rank rank) {
        if (rank.isSecond()) {
            return String.format("%d개 일치, 보너스 볼 일치", rank.getMatchCount());
        }
        return String.format("%d개 일치", rank.getMatchCount());
    }

    public static void printPrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.2f입니다.", prizeRate);

        String result = "이득";
        if (prizeRate < 1) {
            result = "손해";
        }

        System.out.printf("(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n", result);
    }


}
