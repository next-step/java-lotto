package lotto.controller;

import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class GameController {

    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BEFORE_LOTTO_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";

    public void start() {
        Game game = new Game();

        ResultView.print(BUY_MESSAGE);
        int prise = InputView.intInput();
        game.buyLotto(prise);

        ResultView.print(BEFORE_LOTTO_NUMBER);
        Lotto beforeLotto = InputView.inputBeforeLotto();
        game.result(beforeLotto);
    }
}
