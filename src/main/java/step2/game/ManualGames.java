package step2.game;

import step2.analyze.Prize;
import step2.analyze.WinningCount;
import step2.numbers.InputNumbersUtil;
import step2.numbers.LottoGame;
import step2.numbers.Number;
import step2.numbers.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class ManualGames {
    private List<LottoGame> games;

    public ManualGames(List<String> manualNumbers) {
        games = new ArrayList<>();
        for ( String manualNumber : manualNumbers ) {
            addGame(manualNumber);
        }
    }

    private void addGame(String manualGame) {
        List<Number> inputNumbers = InputNumbersUtil.toNumberList(manualGame);
        InputNumbersUtil.verifyLottoNumberCount(inputNumbers);
        games.add(new LottoGame(inputNumbers));
    }

    public void checkWinningCount(WinningCount winningCount, WinningLotto winningLotto) {
        for ( LottoGame lottoGame : games ) {
            Prize prize
                    = Prize.of(lottoGame.matchWinningNumberCount(winningLotto), lottoGame.containsBonus(winningLotto));
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
