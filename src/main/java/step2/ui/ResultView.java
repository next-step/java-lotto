package step2.ui;

import step2.domain.Lottos;
import step2.domain.MatchesResult;
import step2.domain.Score;

public class ResultView {
    public static int totalWinnings = 0;

    public static void outputOfWinningResults(MatchesResult matchesResult, int moneyInput) {
        printEndingMsg();
        matchesResult.getResults().forEach((key, value) -> getResultMsg(value, Score.getScore(key)));
        printYields(moneyInput);
    }

    private static void printEndingMsg() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    static void getResultMsg(Long value, Score score) {
        totalWinnings += score.getPrize() * value;
        System.out.println(score.getTargetNumber() + "개 일치 (" + score.getPrize() + "원)- " + value + "개");
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
