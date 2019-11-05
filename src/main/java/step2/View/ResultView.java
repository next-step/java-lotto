package step2.View;

import step2.Game;
import step2.Ticket;
import step2.Prize;
import step2.Winning;

import java.util.List;
import java.util.Set;

public class ResultView {
    private static final String RESULT = "당첨 통계\n---------";
    private static final String WINNING_COUNT_POSTFIX = "개 일치 (";
    private static final String WINNING_PRIZE_POSTFIX = ") - ";
    private static final String WINNING_GAME_POSTFIX = "개";
    private static final String WINNING_RATE_PREFIX = "총 수익률은 ";
    private static final String WINNING_REPORT_PREFIX = "입니다.(기준이 1이기 때문에 결과적으로 ";
    private static final String WINNING_REPORT_POSTFIX = "(이)라는 의미임)";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";

    public static void checkout(List<Game> games) {
        games.forEach(game -> System.out.println(game.gameNumbers()));
        System.out.println();
    }

    public static void analyze(Ticket ticket, Winning winningNumbers, int pickCount) {
        System.out.println();
        System.out.println(RESULT);
        int[] report = ticket.report(winningNumbers, pickCount);
        System.out.println(3 + WINNING_COUNT_POSTFIX + Prize.FORTH_PRIZE.getMoney() +
                WINNING_PRIZE_POSTFIX + report[3] + WINNING_GAME_POSTFIX);
        System.out.println(4 + WINNING_COUNT_POSTFIX + Prize.THIRD_PRIZE.getMoney() +
                WINNING_PRIZE_POSTFIX + report[4] + WINNING_GAME_POSTFIX);
        System.out.println(5 + WINNING_COUNT_POSTFIX + Prize.SECOND_PRIZE.getMoney() +
                WINNING_PRIZE_POSTFIX + report[5] + WINNING_GAME_POSTFIX);
        System.out.println(6 + WINNING_COUNT_POSTFIX + Prize.FIRST_PRIZE.getMoney() +
                WINNING_PRIZE_POSTFIX + report[6] + WINNING_GAME_POSTFIX);

        float earning = ticket.earning();
        System.out.println(WINNING_RATE_PREFIX + earning + WINNING_REPORT_PREFIX
                + (earning > 1 ? GAIN : LOSS) + WINNING_REPORT_POSTFIX);
    }
}
