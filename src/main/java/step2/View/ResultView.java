package step2.View;

import step2.Game;
import step2.Ticket;

import java.util.List;

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
//        tickets 루프 돌며 출력
    }

    public static void printAnalysis() {
        printNewLine();
        System.out.println(RESULT);
//        등수별 정보와 당첨정보 출력
//        수익률 출력
    }

    private static void printNewLine() {
        System.out.println();
    }


}
