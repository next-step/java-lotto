package lotto.view;

import lotto.LottoGameController;
import lotto.domain.Lottos;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.WinningStatistics;

import java.util.Map;

/**
 * Created By mand2 on 2020-11-18.
 */
public class ResultView {

    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_STATISTICS = "당첨 통계";
    private static final String RESULT_STATISTICS = "%d개 일치 (%d원)";
    private static final String RESULT_NUMBER = "- %d개";
    private static final String EARNING_RATIO = "총 수익률은 %.2f입니다.";
    private static final String DASH = "----------";

    public static void showBoughtLottos(Lottos lottos) {
        lottos.list().forEach(lotto -> System.out.println(lotto.number()));
        System.out.println();
    }

    // TODO inputView 로 옮겨야함.
    public static WinningNumber askWinningNumberAndBonus() {
        return WinningNumber.of(askWinningNumber(), askBonusBall());
    }

    private static String askWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);
        return LottoGameController.SCANNER.nextLine();
    }

    private static String askBonusBall() {
        System.out.println(QUESTION_BONUS_BALL);
        return LottoGameController.SCANNER.nextLine();
    }




    public static void showResults(WinningStatistics winningStatistics, int amount) {
        simpleResultMessage();
        showStatistics(winningStatistics);
        showEarningRatio(winningStatistics, amount);
    }

    private static void simpleResultMessage() {
        System.out.println();
        System.out.println(MESSAGE_STATISTICS);
        System.out.println(DASH);
    }

    private static void showStatistics(WinningStatistics winningStatistics) {
        Map<WinningRank, Integer> resultStats = winningStatistics.stats();
        resultStats.keySet().stream().filter(stats -> stats!=WinningRank.NONE)
                .forEach(winningRank -> {
                    printEachRank(winningRank);
                    printEachNumber(resultStats.get(winningRank));
                });
    }

    private static void printEachRank(WinningRank winningRank) {
        System.out.print(String.format(RESULT_STATISTICS
                , winningRank.getMatchCount()
                , winningRank.getPrize()));
    }

    private static void printEachNumber(int resultNumber) {
        System.out.println(String.format(RESULT_NUMBER, resultNumber));
    }

    private static void showEarningRatio(WinningStatistics winningStatistics, int amount) {
        System.out.println(String.format(EARNING_RATIO, winningStatistics.earningRatio(amount)));
    }
}
