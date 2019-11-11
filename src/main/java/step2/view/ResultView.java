package step2.view;

import step2.analyze.WinningCount;
import step2.game.Ticket;
import step2.game.WinningLotto;

public class ResultView {
    private static final String AMOUNT_CONFIRM_POSTFIX = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String RESULT = "당첨 통계\n---------";
    private static final String PRIZE_WITH_BONUS = ", 보너스 볼 일치";
    private static final String EMPTY = "";
    private static final String WINNING_REPORT_FORMAT = "%d개 일치%s (%d원) - %d개";
    private static final String WINNING_RATE_FORMAT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";

    public static void printTickets(Ticket ticket) {
        int autoCount = ticket.getAutoCount();
        int manualCount = ticket.getManualCount();
        System.out.println(String.format(AMOUNT_CONFIRM_POSTFIX, manualCount, autoCount));
        for (int i = 0; i < manualCount; i++) {
            System.out.println("[" + ticket.toStringManualNumbers(i) + "]");
        }
        for (int i = 0; i < autoCount; i++) {
            System.out.println("[" + ticket.toStringAutoNumbers(i) + "]");
        }
    }

    public static void printAnalysis(Ticket ticket, WinningLotto winningLottoNumber) {
        printNewLine();
        System.out.println(RESULT);
        WinningCount winningCount = ticket.checkWinningCount(winningLottoNumber);
        printWinningCount(winningCount);
        printWinningRate(winningCount);
    }

    private static void printWinningCount(WinningCount winningCount) {
        winningCount.getWinningCountWithoutZero().forEach((prize, count) -> {
            System.out.println(
                    String.format(WINNING_REPORT_FORMAT, prize.getMatchCount(),
                            prize.isBonus() ? PRIZE_WITH_BONUS : EMPTY,
                            prize.getMoney(), count));
        });
    }

    private static void printWinningRate(WinningCount winningCount) {
        float rate = winningCount.calculateWinningRate();
        System.out.println(String.format(WINNING_RATE_FORMAT, rate, (rate > 1) ? GAIN : LOSS));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
