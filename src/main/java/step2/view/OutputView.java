package step2.view;

import static step2.util.StringConstant.DELIMITER_COMMA;
import static step2.util.StringConstant.NEW_LINE;
import static step2.view.Message.BY_AUTO;
import static step2.view.Message.BY_MANUAL;
import static step2.view.Message.GAME_SIZE;
import static step2.view.Message.SAME_COUNT;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import step2.domain.Game;
import step2.domain.Lotto;
import step2.domain.Rank;

public class OutputView {

    public static void printGameSize(Lotto lotto) {
        StringBuilder gameSize = new StringBuilder();
        gameSize.append(BY_MANUAL)
            .append(lotto.manualGameSize())
            .append(DELIMITER_COMMA)
            .append(" ")
            .append(BY_AUTO)
            .append(lotto.autoGameSize())
            .append(GAME_SIZE);
        System.out.println(gameSize);
    }

    public static void printGames(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println(Message.GAME_STATISTICS);
        System.out.println("-------");
    }

    public static void printResult(Lotto lotto) {
        Map<Rank, List<Game>> candidate = lotto.candidate();
        StringBuilder result = new StringBuilder();
        Arrays.stream(Rank.values())
            .filter(rank -> !rank.equals(Rank.MISS))
            .forEach(rank -> {
                result.append(rank.getCountOfMatch())
                    .append(SAME_COUNT)
                    .append(rank.getWinningMoney())
                    .append(" - ")
                    .append(candidateSize(candidate, rank))
                    .append(NEW_LINE);
            });

        System.out.println(result);
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %s 입니다.\n", String.format("%.2f", profit));
    }

    private static int candidateSize(Map<Rank, List<Game>> candidate, Rank rank) {
        List<Game> games = candidate.get(rank);
        if (games == null) {
            return 0;
        }
        return games.size();
    }
}
