package lotto;

import lotto.Model.*;
import lotto.View.*;

import java.util.List;

public class LottoController {
    public void start() {
        int countOfTicket = InputView.payment();
        System.out.println(countOfTicket + "개를 구매했습니다.");

        Game game = new Game(countOfTicket);
        ResultView.printTickets(game.allTickets());

        List<Integer> winnerNumber = InputView.winnerNumber();
        int bonusNumber = InputView.bonusNumber();
        GameResult result = game.calculateResult(winnerNumber, bonusNumber);
        ResultView.printResult(countOfTicket, result);
    }
}
