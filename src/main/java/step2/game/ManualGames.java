package step2.game;

import step2.numbers.InputNumbersUtil;
import step2.numbers.LottoGame;
import step2.numbers.Number;

import java.util.ArrayList;
import java.util.List;

public class ManualGames implements GameStrategy {
    private List<LottoGame> games;

    public ManualGames(List<String> manualNumbers) {
        games = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            addGame(manualNumber);
        }
    }

    public List<LottoGame> getGames() {
        return games;
    }

    private void addGame(String manualGame) {
        List<Number> inputNumbers = InputNumbersUtil.toNumberList(manualGame);
        InputNumbersUtil.verifyLottoNumberCount(inputNumbers);
        games.add(new LottoGame(inputNumbers));
    }

    public int size() {
        return games.size();
    }

    public String toString(int index) {
        return games.get(index).toString();
    }
}
