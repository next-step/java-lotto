package lotto.controller;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.view.InputView;
import lotto.view.ResultView;

public class GameController {

    public void start() {
        int price = InputView.buyingLotto();
        Game game = Game.buyingLotto(price);

        Lotto beforeLotto = InputView.typingBeforeLotto();
        Prize prize = game.result(beforeLotto);

        ResultView.printPrize(prize);
    }
}
