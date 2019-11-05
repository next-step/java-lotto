package step2;

import java.util.List;

public class Ticket {
    List<Game> games;

    public Ticket(List<Game> games) {
        this.games = games;
    }

    public int[] report(Winning lottoNumbers, int pickCount) {
        int[] gameResult = new int[pickCount + 1];
        games.forEach(game -> {
            gameResult[game.score(lottoNumbers)]++;
        });
        return gameResult;
    }

    public float earning(int[] gameResult) {
        float payMoney = games.size() * 1000;
        float getMoney = (gameResult[3] * 5000) + (gameResult[4] * 50000)
                + (gameResult[5] * 1500000) + (gameResult[6] * 2000000000);
        return getMoney / payMoney;
    }
}
