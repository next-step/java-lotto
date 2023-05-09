package lotto;

import lotto.Model.*;
import lotto.View.*;

import java.util.List;

public class LottoController {
    public void start() {
        int countOfTicket = InputView.payment();
        List<Ticket> manualTickets = InputView.manualBuy(countOfTicket);
        System.out.println("수동으로 " + manualTickets.size() + "장, 자동으로 " + (countOfTicket - manualTickets.size()) + "개를 구매했습니다.");

        Game game = new Game(countOfTicket, manualTickets);
        ResultView.printTickets(game.allTickets());

        List<Integer> winnerNumber = InputView.winnerNumber();
        int bonusNumber = InputView.bonusNumber();
        GameResult result = game.calculateResult(winnerNumber, bonusNumber);
        ResultView.printResult(countOfTicket, result);
    }
}
