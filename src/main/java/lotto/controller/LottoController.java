package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.inputGameMoney();
        int manualTicketCount = inputView.inputManualTicketCount();
        List<String> manualTicketTexts = inputView.inputManualTicketTexts(manualTicketCount);

        LottoGame game = LottoGame.of(money, manualTicketTexts);

        resultView.printMyTicket(game.getTicketsString(), manualTicketCount);

        String text = inputView.inputWinText();
        int bonusNumber = inputView.inputBonusNumber();

        resultView.printLottoStatistics(game.doGame(text, bonusNumber));

    }
}
