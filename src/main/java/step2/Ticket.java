package step2;

import java.util.List;
import java.util.Set;

public class Ticket {
    List<Game> games;
    Set<Integer> lottoNumbers;
    int[] gameResult;

    public Ticket(List<Game> games, Set<Integer> lottoNumbers) {
        this.games = games;
        this.lottoNumbers = lottoNumbers;
    }

    public int[] report(int pickCount) {
        gameResult = new int[pickCount + 1];
        games.forEach(game -> {
            gameResult[game.score(lottoNumbers)]++;
        });
        return gameResult;
    }

    public float earning() {
        float payMoney = games.size() * 1000;
        float getMoney = (gameResult[3] * 5000) + (gameResult[4] * 50000)
                + (gameResult[5] * 1500000) + (gameResult[6] * 2000000000);
        return getMoney / payMoney;
    }
}
