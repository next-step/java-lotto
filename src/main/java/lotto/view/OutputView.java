package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Prize;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String BUY_LOTTOS = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "당첨 통계";
    private static final String DASH = "---------";
    private static final String TOTAL_PROPIT = "총 수익률은 ";
    private static final String PROPIT_END = "입니다.";
    private static final String GAME_RESULT = "%d개 일치 (%d원)- %d개";
    public static final String SECOND_PRIZE_PRINT = "%d개 일치 보너스 볼 일치(%d원)- %d개";
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public void showResult(GameResult gameResult) {
        System.out.println(WINNING_RESULT);
        System.out.println(DASH);
        for (Prize prize : Prize.values()) {
            showGameResult(prize, gameResult);
        }
    }

    public void showInputResult(final List<Lotto> lottos, int allLottoCounts, int manualConunts) {
        int autoLottoCounts =  allLottoCounts - manualConunts;
        StringBuilder sb = new StringBuilder();

        sb.append("수동으로 " + manualConunts + "장, 자동으로 " + autoLottoCounts + "개를 구매했습니다.");
        sb.append(System.lineSeparator());

        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }


    /**
     * 3개 일치 (5000원)- 1개
     *
     * @param prize
     * @param gameResult
     */
    private void showGameResult(Prize prize, GameResult gameResult) {
        if (Prize.MISS == prize) {
            return;
        }
        printSecond(prize, gameResult);

        if (Prize.SECOND != prize) {
            System.out.println(String.format(GAME_RESULT,
                    prize.getMatch(),
                    prize.getAmount(),
                    gameResult.getWinResult(prize)));
        }
    }

    private void printSecond(Prize prize, GameResult gameResult) {
        if (Prize.SECOND == prize) {
            System.out.println(String.format(SECOND_PRIZE_PRINT,
                    prize.getMatch(),
                    prize.getAmount(),
                    gameResult.getWinResult(prize)));
        }
    }

    public void showProfit(final Money purchasedAmount, final GameResult gameResult) {
        System.out.println(TOTAL_PROPIT + decimalFormat.format(gameResult.getProfit(purchasedAmount)) + PROPIT_END);
    }


}
