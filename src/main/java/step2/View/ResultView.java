package step2.View;

import step2.Data.Prize;
import step2.Model.LottoGame;
import step2.Model.Ticket;
import step2.Model.WinningCount;
import step2.Model.WinningLotto;

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
        List<LottoGame> lottoGames = ticket.getLottoGames();
        System.out.println(lottoGames.size() + AMOUNT_CONFIRM_POSTFIX);
        lottoGames.forEach(lottoGame -> System.out.println("[" + lottoGame.toString() + "]"));
    }

    public static void printAnalysis(Ticket ticket, WinningLotto winningLottoNumber) {
        printNewLine();
        System.out.println(RESULT);
        WinningCount winningCount = ticket.checkWinningCount(winningLottoNumber);
        printWinningCount(winningCount);
        printWinningRate(winningCount);
    }

    private static void printWinningCount(WinningCount winningCount) {
        for (int matchCount = WinningCount.MIN_MATCH_COUNT;
             matchCount <= WinningCount.MAX_MATCH_COUNT; matchCount++) {
            System.out.println(matchCount + WINNING_COUNT_POSTFIX
                    + Prize.getPrice(matchCount) + WINNING_PRIZE_POSTFIX
                    + winningCount.countOfMatchCount(matchCount) + WINNING_GAME_POSTFIX);
        }
    }

    private static void printWinningRate(WinningCount winningCount) {
        float rate = winningCount.calculateWinningRate();
        System.out.println(WINNING_RATE_PREFIX + rate + WINNING_REPORT_PREFIX +
                (rate > 1 ? GAIN : LOSS) + WINNING_REPORT_POSTFIX);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
