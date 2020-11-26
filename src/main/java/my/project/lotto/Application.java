package my.project.lotto;

import my.project.lotto.controller.StatController;
import my.project.lotto.domain.GameRecord;
import my.project.lotto.domain.Lottos;
import my.project.lotto.domain.Ticket;
import my.project.lotto.view.InputView;
import my.project.lotto.view.ResultView;

import java.util.List;

/**
 * Created : 2020-11-23 오전 10:52
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Ticket ticket = new Ticket(inputView.getMoney());
        List<GameRecord> records = Lottos.lotto(ticket);
        resultView.printGame(records);

        StatController statController = new StatController(records, inputView.getWinningNumber());
        resultView.printStat(statController.stat());
    }
}
