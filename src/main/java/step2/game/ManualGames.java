package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class ManualGames {
    private List<LottoGame> manualGames;

    public ManualGames() {
        this.manualGames = new ArrayList<>();
    }

    public void addGame(ManualGame manualGame) {
        manualGames.add(manualGame);
    }

    public int size() {
        return manualGames.size();
    }

    public void getWinningCount(WinningCount winningCount, WinningLotto winningLotto) {
        for (LottoGame lottoGame : manualGames) {
            Prize prize = Prize.of(lottoGame.matchWinningNumberCount(winningLotto),
                    lottoGame.containsBonus(winningLotto));
            winningCount.addCount(prize);
        }
    }

    public String toString(int index) {
        return manualGames.get(index).toString();
    }
}
