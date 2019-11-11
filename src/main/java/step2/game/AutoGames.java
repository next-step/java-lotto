package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class AutoGames {
    private List<LottoGame> games;

    private AutoGames() {
        games = new ArrayList<>();
    }

    public static AutoGames buy(int autoCount) {
        AutoGames autoGames = new AutoGames();
        for (int count = 0; count < autoCount; count++) {
            autoGames.addGame();
        }
        return autoGames;
    }

    private void addGame() {
        games.add(LottoGame.ofRandom());
    }

    public void checkWinningCount(WinningCount winningCount, WinningLotto winningLotto) {
        for (LottoGame lottoGame : games) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
    }

    public int size() {
        return games.size();
    }

    public String toString(int index) {
        return games.get(index).toString();
    }
}
