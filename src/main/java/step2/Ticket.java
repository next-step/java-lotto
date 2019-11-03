package step2;

import java.util.List;
import java.util.Set;

public class Ticket {
    List<Game> games;
    int[] gameResult;
    Set<Integer> lottoNumbers;


    public Ticket(List<Game> games, Set<Integer> lottoNumbers, int limit) {
        this.games = games;
        this.lottoNumbers = lottoNumbers;
        this.gameResult = new int[limit];
    }

    public int[] report() {
        games.forEach(game -> {
            gameResult[game.score(lottoNumbers)]++;
        });
        return gameResult;
    }
}
