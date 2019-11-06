package step2.View;

import step2.Game;
import step2.Prize;
import step2.Ticket;

import java.util.List;
import java.util.Set;

import static step2.LottoUtil.LOTTO_PRIZE_MAX_CORRECT_NUMBER;
import static step2.LottoUtil.LOTTO_PRIZE_MIN_CORRECT_NUMBER;

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

    public static void printAnalysis(Ticket ticket, Set<Integer> winningNumber) {
        printNewLine();
        System.out.println(RESULT);
        printWinningCount(ticket.checkWinningCount(winningNumber));
//        수익률 출력

    }

    private static void printWinningCount(int[] winningCount) {
        for (int correctNumber = LOTTO_PRIZE_MIN_CORRECT_NUMBER;
             correctNumber < LOTTO_PRIZE_MAX_CORRECT_NUMBER; correctNumber++) {
            System.out.print(correctNumber + WINNING_COUNT_POSTFIX
                    + Prize.getPrice(correctNumber) + WINNING_PRIZE_POSTFIX
                    + winningCount[correctNumber] + WINNING_GAME_POSTFIX);
        }
    }


    private static void printNewLine() {
        System.out.println();
    }


}
