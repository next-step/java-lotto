package step2.game;

import step2.numbers.InputNumbersUtil;
import step2.numbers.LottoGame;
import step2.numbers.Number;

import java.util.ArrayList;
import java.util.List;

public class ManualGames implements GameStrategy {
    public static final String STRATEGY = "MANUAL";
    private final List<LottoGame> games;

    public ManualGames(List<String> manualNumbers) {
        List<LottoGame> lottoGames = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            lottoGames.add(new LottoGame(verifyInputNumber(manualNumber)));
        }
        this.games = lottoGames;
    }

    public List<LottoGame> getGames() {
        return games;
    }

    private List<Number> verifyInputNumber(String manualGame) {
        List<Number> inputNumbers = InputNumbersUtil.toNumberList(manualGame);
        InputNumbersUtil.verifyLottoNumberCount(inputNumbers);
        return inputNumbers;
    }

    public int size() {
        return games.size();
    }

    public String toString(int index) {
        return games.get(index).toString();
    }
}
