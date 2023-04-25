package lotto;

import lotto.Model.Game;
import lotto.View.*;

public class LottoController {
    public void start() {
        int countOfTicket = InputView.payment();
        System.out.println(countOfTicket+"개를 구매했습니다.");

        Game game = new Game(countOfTicket);
        ResultView.printTickets(game.allTickets());

        // getWinningNumbers();
        // calculateResult();
    }
}
