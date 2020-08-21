package step2.ui;

import step2.domain.Lotto;
import step2.domain.MatchesResult;
import step2.domain.Score;

import java.util.List;

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

    public static void printMyGame(List<Lotto> lottos) {
        lottos.forEach((list) -> System.out.println("[" + list.getLotteryPaper() + "]"));
    }

    public static void printYields(int grossMargin) {
        double percent = (double) grossMargin / (double) totalWinnings * 100.0;
        System.out.println("총 수익률은 " + percent + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
