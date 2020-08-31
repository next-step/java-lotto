package step2.ui;

import step2.domain.Lottos;
import step2.domain.MatchesResult;
import step2.domain.ScoreType;

public class ResultView {
    public static int totalWinnings = 0;

    public static void outputOfWinningResults(MatchesResult matchesResult, int moneyInput) {
        printEndingMsg();
        matchesResult.getResults().forEach((key, value) -> getResultMsg(value, key));
        printYields(moneyInput);
    }

    private static void printEndingMsg() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    static void getResultMsg(Long value, ScoreType scoreType) {
        totalWinnings += scoreType.getPrize() * value;
        System.out.println(scoreType.getTargetNumber() + "개 일치" + scoreType.getWinnerMsg() + "- " + value + "개");
    }

    public static void printMyGameList(int totalManualGameCount, int totalAutoGameCount) {
        String gameListMsg = "";
        if (totalManualGameCount > 0) {
            gameListMsg += "수동으로 " + totalManualGameCount + "장,";
        }
        gameListMsg += "자동으로 " + totalAutoGameCount + "장을 구매했습니다.";
        System.out.print(gameListMsg);
    }

    public static void printMyGame(Lottos lottos) {
        lottos.getLottos().forEach((list) -> System.out.println("[" + list.toString() + "]"));
    }

    public static void printYields(int grossMargin) {
        System.out.println("총 수익률은 " + getPercent(grossMargin) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static double getPercent(int grossMargin) {
        if (totalWinnings == 0) {
            return 0;
        }
        return grossMargin / (double) totalWinnings * 100.0;
    }
}
