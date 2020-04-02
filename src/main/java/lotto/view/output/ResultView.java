package lotto.view.output;

import lotto.model.Rank;
import lotto.model.gameresult.EarningRate;
import lotto.model.gameresult.GameResult;
import lotto.model.gameresult.MatchingResult;
import lotto.model.lotto.MyLottos;

import java.util.Arrays;

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

        printStatisticsWithTitle();
        printEarningRate(gameResult.getEarningRate());
    }

    private static void printStatisticsWithTitle() {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        printStatistics();
    }

    private static void printStatistics() {
        Arrays.stream(Rank.values())
                .forEach(rank -> printStatistic(rank));
    }

    private static void printStatistic(Rank rank) {
        if (SECOND.equals(rank)) {
            System.out.print(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getCashPrize() + "원) : ");
            System.out.println(MatchingResult.findRankCount(rank) + "개");
        }

        if (!SECOND.equals(rank)) {
            System.out.print(rank.getMatchCount() + "개 일치 (" + rank.getCashPrize() + "원) : ");
            System.out.println(MatchingResult.findRankCount(rank) + "개");
        }
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate.getEarningRate()) + "%입니다.");
    }
}