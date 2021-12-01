package lotto.view;

import lotto.game.Game;
import lotto.game.Rank;
import lotto.game.Round;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final Rank[] RANK_TO_PRINT = new Rank[]{
            Rank.FORTH_WIN,
            Rank.THIRD_WIN,
            Rank.SECOND_WIN,
            Rank.FIRST_WIN
    };

    private OutputView() {}

    public static void printGameCount(int gameCount) {
        print(String.format("%d개를 구매했습니다.", gameCount));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void printGames(List<Game> games) {
        games.forEach(game -> {
            print(game.toString());
        });
    }

    public static void printResult(int amount, long totalAward, EnumMap<Rank, Integer> result) {
        print("당첨 통계");
        print("---------");
        for (Rank rank : RANK_TO_PRINT) {
            int count = result.getOrDefault(rank, 0);
            print(String.format("%d개 일치 (%d원)- %d개", rank.count, rank.award, count));
        }
        print(String.format("총 수익률은 %.2f입니다.", (float)totalAward / amount));
    }
}
