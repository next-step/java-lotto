package step2.view;

import static step2.util.StringConstant.NEW_LINE;
import static step2.view.Message.SAME_COUNT;

import step2.domain.Candidate;
import step2.domain.Lotto;
import step2.domain.Payout;

public class OutputView {

    public static void printGameSize(Lotto lotto) {
        System.out.println(lotto.size() + Message.GAME_SIZE);
    }

    public static void printGames(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println(Message.GAME_STATISTICS);
        System.out.println("-------");
    }

    public static void printResult(Candidate candidate) {
        StringBuilder result = new StringBuilder();
        for (int prizeRank = 3; prizeRank <= 6; ++prizeRank) {
            result.append(prizeRank)
                .append(SAME_COUNT)
                .append(Payout.money(prizeRank))
                .append(" - ")
                .append(candidate.count(prizeRank))
                .append(NEW_LINE);
        }

        System.out.println(result);
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %s 입니다.\n", String.format("%.2f", profit));
    }
}
