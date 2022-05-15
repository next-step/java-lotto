package lotto.controller;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.controller.GameController.GameType.*;

public class GameController {

    private GameController() {
    }

    public static void start(GameType gameType) {
        Game game = createGame(gameType);
        Lotto beforeLotto = InputView.getBeforeLotto();

        if (gameType.equals(AUTO)) {
            gameStart(game, beforeLotto);
        }

        if (gameType.equals(BONUS) || gameType.equals(MANUAL)) {
            gameStartWithBonus(game, beforeLotto);
        }
    }

    private static Game createGame(GameType gameType) {
        if (gameType.equals(MANUAL)) {
            return InputView.createGameByManual();
        }

        return InputView.createGameByAuto();
    }

    private static void gameStart(Game game, Lotto beforeLotto) {
        Prize prize = game.findWinners(beforeLotto);
        ResultView.print(prize);
    }

    private static void gameStartWithBonus(Game game, Lotto beforeLotto) {
        Number bonusNumber = InputView.getBonusNumber();
        Prize prize = game.findWinners(beforeLotto, bonusNumber);
        ResultView.print(prize);
    }

    public enum GameType {
        AUTO, BONUS, MANUAL
    }
}
