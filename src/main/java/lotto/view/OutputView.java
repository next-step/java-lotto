package lotto.view;

import lotto.game.Game;
import lotto.game.Round;

import java.util.List;

public class OutputView {
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
}
