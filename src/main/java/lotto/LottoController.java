package lotto;

import lotto.Model.Game;
import lotto.View.*;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    public void start() {
        int countOfTicket = InputView.payment();
        System.out.println(countOfTicket + "개를 구매했습니다.");

        Game game = new Game(countOfTicket);
        ResultView.printTickets(game.allTickets());

        List<Integer> winnerNumber = InputView.winnerNumber();
        HashMap<Integer, Integer> result = game.calculateResult(winnerNumber);
        ResultView.printResult(countOfTicket, result);
    }
}
