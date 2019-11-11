package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class AutoGames {
    private List<LottoGame> autoGames;

    public AutoGames() {
        autoGames = new ArrayList<>();
    }

    public void getWinningCount(WinningCount winningCount, WinningLotto winningLotto) {
        for (LottoGame lottoGame : autoGames) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
    }

    public void addGame(AutoGame autoGame) {
        autoGames.add(autoGame);
    }

    public int size() {
        return autoGames.size();
    }

    public String toString(int index) {
        return autoGames.get(index).toString();
    }
}
