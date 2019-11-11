package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;

import java.util.ArrayList;
import java.util.List;

public class ManualGames {
    private List<LottoGame> games;

    private ManualGames() {
        this.games = new ArrayList<>();
    }

    public static ManualGames buy(List<String> manualNumbers) {
        ManualGames manualGames = new ManualGames();
        for (String manualNumber : manualNumbers) {
            manualGames.addGame(manualNumber);
        }
        return manualGames;
    }

    private void addGame(String manualGame) {
        games.add(LottoGame.ofManual(manualGame));
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
