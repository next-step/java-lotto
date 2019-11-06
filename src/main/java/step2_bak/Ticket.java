package step2_bak;

import step2_bak.Data.AnalysisData;

import java.util.List;

public class Ticket {
    private List<Game> games;

    public Ticket(List<Game> games) {
        this.games = games;
    }

    public AnalysisData analysis(Winning lottoNumbers, int pickCount, int minPrize) {
        int[] gameResult = scores(lottoNumbers, pickCount);
        return new AnalysisData(gameResult, earning(gameResult, minPrize), minPrize);
    }

    public int[] scores(Winning lottoNumbers, int pickCount) {
        int[] gameResult = new int[pickCount + 1];
        games.forEach(game -> {
            gameResult[game.score(lottoNumbers)]++;
        });
        return gameResult;
    }

    private float earning(int[] gameResult, int minPrize) {
        float payMoney = games.size() * 1000;

        float getMoney = 0;
        for ( int index = minPrize; index < gameResult.length; index++ ) {
            getMoney += gameResult[index] * Prize.getMoney(index);
        }
        return getMoney / payMoney;
    }
}
