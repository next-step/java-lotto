package lotto.view.output;

import lotto.model.Rank;
import lotto.model.gameresult.EarningRate;
import lotto.model.gameresult.GameResult;
import lotto.model.gameresult.MatchingResult;
import lotto.model.mylottos.MyLottos;

import static lotto.model.Rank.SECOND;

public class ResultView {
    public static void printMyLottos(MyLottos myLottos) {
        System.out.println(myLottos.findLottoCount() + "개를 구매했습니다.");

        myLottos.getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));

        System.lineSeparator();
    }

    public static void printResult(GameResult gameResult) {
        System.lineSeparator();

        printStatisticsWithTitle(gameResult.getMatchingResult());
        printEarningRate(gameResult.getEarningRate());
    }

    private static void printStatisticsWithTitle(MatchingResult matchingResult) {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        printStatistics(matchingResult);
    }

    private static void printStatistics(MatchingResult matchingResult) {
        for (Rank rank : Rank.values()) {
            printStatisticExceptSecond(matchingResult, rank);
        }
        printStatisticForSecond(matchingResult, SECOND);

    }

    private static void printStatisticExceptSecond(MatchingResult matchingResult, Rank rank) {
        if (!SECOND.equals(rank)) {
            System.out.print(rank.getMatchCount() + "개 일치 (" + rank.getCashPrize() + "원) : ");
            System.out.println(matchingResult.findMatchCount(rank) + "개");
        }
    }

    private static void printStatisticForSecond(MatchingResult matchingResult, Rank rank) {
        if (SECOND.equals(rank)) {
            System.out.print(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getCashPrize() + "원) : ");
            System.out.println(matchingResult.findMatchCount(rank) + "개");
        }
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate.getEarningRate()) + "%입니다.");
    }
}