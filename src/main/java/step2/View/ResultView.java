package step2.View;

import step2.Data.Prize;
import step2.Model.Game;
import step2.Model.Ticket;
import step2.Model.WinningCount;
import step2.Model.WinningNumbers;

import java.util.List;

import static step2.Util.LottoUtil.LOTTO_PRIZE_MAX_CORRECT_NUMBER;
import static step2.Util.LottoUtil.LOTTO_PRIZE_MIN_CORRECT_NUMBER;

public class ResultView {
    private static final String AMOUNT_CONFIRM_POSTFIX = "개를 구매했습니다.";
    private static final String RESULT = "당첨 통계\n---------";
    private static final String WINNING_COUNT_POSTFIX = "개 일치 (";
    private static final String WINNING_PRIZE_POSTFIX = ") - ";
    private static final String WINNING_GAME_POSTFIX = "개";
    private static final String WINNING_RATE_PREFIX = "총 수익률은 ";
    private static final String WINNING_REPORT_PREFIX = "입니다.(기준이 1이기 때문에 결과적으로 ";
    private static final String WINNING_REPORT_POSTFIX = "(이)라는 의미임)";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";

    public static void printTickets(Ticket ticket) {
        List<Game> games = ticket.getGames();
        System.out.println(games.size() + AMOUNT_CONFIRM_POSTFIX);
        games.forEach(game -> System.out.println("[" + game.getNumbers() + "]"));
    }

    public static void printAnalysis(Ticket ticket, WinningNumbers winningNumbersNumber) {
        printNewLine();
        System.out.println(RESULT);
        WinningCount winningCount = ticket.checkWinningCount(winningNumbersNumber);
        printWinningCount(winningCount);
        printWinningRate(winningCount);
    }

    private static void printWinningCount(WinningCount winningCount) {
        for (int correctNumber = LOTTO_PRIZE_MIN_CORRECT_NUMBER;
             correctNumber <= LOTTO_PRIZE_MAX_CORRECT_NUMBER; correctNumber++) {
            System.out.println(correctNumber + WINNING_COUNT_POSTFIX
                    + Prize.getPrice(correctNumber) + WINNING_PRIZE_POSTFIX
                    + winningCount.getCount(correctNumber) + WINNING_GAME_POSTFIX);
        }
    }

    private static void printWinningRate(WinningCount winningCount) {
        float rate = winningCount.getWinningRate();
        System.out.println(WINNING_RATE_PREFIX + rate + WINNING_REPORT_PREFIX +
                (rate > 1 ? GAIN : LOSS) + WINNING_REPORT_POSTFIX);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
