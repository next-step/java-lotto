package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {



    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();


        int money = inputView.inputGameMoney();
        LottoGame game = new LottoGame(money);

        resultView.printMyTicket(game.getTicketsString());
        resultView.printNewLine();


        String winText = inputView.inputWinText();
        resultView.printNewLine();

        resultView.printWinStatistics(game.getResultString(winText));

    }
}
