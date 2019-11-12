package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.inputGameMoney();
        LottoGame game = LottoGame.of(money);

        resultView.printMyTicket(game.getTicketsString());

        String text = inputView.inputWinText();
        int bonusNumber = inputView.inputBonusNumber();
        game.doGame(text, bonusNumber);

        resultView.printLottoStatistics(game.getLottoStatistics());
    }
}
