package step2.view;

import static step2.util.StringConstant.NEW_LINE;
import static step2.view.Message.SAME_COUNT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step2.domain.Candidate;
import step2.domain.Game;
import step2.domain.Lotto;
import step2.domain.Rank;

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
                    .append(candidate.get(rank).size())
                    .append(NEW_LINE);
            });

        System.out.println(result);
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %s 입니다.\n", String.format("%.2f", profit));
    }
}
