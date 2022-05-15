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
        Game game = InputView.createGame();
        Lotto beforeLotto = InputView.getBeforeLotto();

        if (gameType.equals(AUTO)) {
            gameStartByAuto(game, beforeLotto);
        }

        if (gameType.equals(BONUS)) {
            gameStartByBonus(game, beforeLotto);
        }

        if (gameType.equals(MANUAL)) {
            gameStartByManual();
        }
    }

    private static void gameStartByAuto(Game game, Lotto beforeLotto) {
        Prize prize = game.findWinners(beforeLotto);
        ResultView.print(prize);
    }

    private static void gameStartByBonus(Game game, Lotto beforeLotto) {
        Number bonusNumber = InputView.getBonusNumber();
        Prize prize = game.findWinners(beforeLotto, bonusNumber);
        ResultView.print(prize);
    }

    private static void gameStartByManual() {
        // 미션 진행 예정
    }

    public enum GameType {
        AUTO, BONUS, MANUAL
    }
}
