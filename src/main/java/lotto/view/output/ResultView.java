package lotto.view.output;

import lotto.model.Rank;
import lotto.model.mylottos.MyLottos;
import lotto.model.result.EarningRate;
import lotto.model.result.GameResult;
import lotto.model.result.MatchingResult;

import static lotto.model.Rank.SECOND;

public class ResultView {
    public static void printMyLottos(MyLottos myLottos) {
        printBlankLine();
        System.out.println(myLottos.findLottoCount() + "개를 구매했습니다.");

        myLottos.getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));
        printBlankLine();
    }

    public static void printResult(GameResult gameResult) {
        printBlankLine();
        printBlankLine();

        printStatistics(gameResult.getMatchingResult());
        printEarningRate(gameResult.getEarningRate());
    }

    private static void printStatistics(MatchingResult matchingResult) {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        printStatistic(matchingResult);
    }

    private static void printStatistic(MatchingResult matchingResult) {
        for (Rank rank : Rank.values()) {
            printStatisticsExceptSecond(matchingResult, rank);
        }
        printStatisticForSecond(matchingResult, SECOND);

    }

    private static void printStatisticsExceptSecond(MatchingResult matchingResult, Rank rank) {
        if (!rank.equals(SECOND)) {
            System.out.print(rank.getMatchCount() + "개 일치 (" + rank.getCashPrize() + "원) : ");
            System.out.println(matchingResult.findMatchCount(rank) + "개");
        }
    }

    private static void printStatisticForSecond(MatchingResult matchingResult, Rank rank) {
        System.out.print(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getCashPrize() + "원) : ");
        System.out.println(matchingResult.findMatchCount(SECOND) + "개");
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate.getEarningRate()) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}