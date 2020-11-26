package my.project.lotto;

import my.project.lotto.controller.LottoController;
import my.project.lotto.controller.StatController;
import my.project.lotto.domain.GameRecord;
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

        LottoController lottoController = new LottoController(inputView.getMoney());
        List<GameRecord> records = lottoController.lotto();
        resultView.printGame(records);

        StatController statController = new StatController(records, inputView.getWinningNumber());
        resultView.printStat(statController.stat());
    }
}
