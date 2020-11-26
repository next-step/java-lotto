package my.project.lotto;

import my.project.lotto.controller.StatController;
import my.project.lotto.domain.Chance;
import my.project.lotto.domain.Lotto;
import my.project.lotto.domain.Lottos;
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

        Chance chance = new Chance(inputView.getMoney());
        List<Lotto> records = Lottos.lotto(chance);
        resultView.printGame(records);

        StatController statController = new StatController(records, inputView.getWinningNumber());
        resultView.printStat(statController.stat());
    }
}
